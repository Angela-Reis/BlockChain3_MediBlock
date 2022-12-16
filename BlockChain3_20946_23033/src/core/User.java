/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import p2p.miner.InterfaceRemoteMiner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myUtils.SecurityUtils;

/**
 * Abstarct class that represents the user
 *
 * @author AR
 */
public abstract class User implements Serializable {

    public final static String USER_PATH = "user/";
    private static final long serialVersionUID = 04L;
    public static int SIZE_RSA_KEY = 2048;
    public static int SIZE_AES_KEY = 256;

    protected final String name;
    protected PrivateKey privKey;
    protected PublicKey pubKey;
    protected Key key;
    private InterfaceRemoteMiner miner;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PrivateKey getPrivKey() {
        return privKey;
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public Key getKey() {
        return key;
    }

    public String getInfo() throws RemoteException {

        StringBuilder txt = new StringBuilder();
        txt.append("\nSimetric Key Algorithm   : " + pubKey.getAlgorithm());
        txt.append("\nSimetric Key Size        : " + SIZE_RSA_KEY);
        txt.append("\nAssimetric Key Algorithm : " + key.getAlgorithm());
        txt.append("\nAssimetric Key Size      : " + SIZE_AES_KEY);
        txt.append("\n\nFiles :");
        txt.append("\n" + USER_PATH + name + ".user");
        txt.append("\n" + USER_PATH + name + ".pub");
        txt.append("\n" + USER_PATH + name + ".priv");
        txt.append("\n" + USER_PATH + name + ".sim");
        txt.append("\nAddress" + miner.getAdress());
        return txt.toString();
    }

    /**
     * Register a new user, the files will be named with the userNumber
     *
     * @param user
     * @param userNumber
     * @param password
     * @throws Exception
     */
    public static void register(User user, String userNumber, String password) throws Exception {
        String path = USER_PATH + userNumber;
        //Create directory if needed
        new File(USER_PATH).mkdirs();
        //Create users
        //Generate keys
        KeyPair kp = SecurityUtils.generateKeyPair(SIZE_RSA_KEY);
        if (new File(path + ".user").exists()) {
            throw new Exception("User with this number already exists");
        }
        //Save user data without any keys
        String nameOfFile = path + ".user";
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        }

        //Get users keys
        user.privKey = kp.getPrivate();
        user.pubKey = kp.getPublic();
        user.key = SecurityUtils.generateAESKey(SIZE_AES_KEY);
        // Save keys
        Files.write(Paths.get(USER_PATH + userNumber + ".pub"), user.pubKey.getEncoded());
        //Encript private key with password
        byte[] dataPriv = user.privKey.getEncoded();
        dataPriv = SecurityUtils.encrypt(dataPriv, password);
        Files.write(Paths.get(USER_PATH + userNumber + ".priv"), dataPriv);
        //Encript simetric key with password
        byte[] dataKey = SecurityUtils.encrypt(user.key.getEncoded(), user.pubKey);
        Files.write(Paths.get(USER_PATH + userNumber + ".sim"), dataKey);

    }

    /**
     * Load user from file .user, load pubKey
     *
     * @param userNumber
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static User load(String userNumber) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        String path = USER_PATH + userNumber;
        //load user from file 
        try (FileInputStream fis = new FileInputStream(path + ".user");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            User user = (User) ois.readObject();
            byte[] pubData = Files.readAllBytes(Paths.get(path + ".pub"));
            user.pubKey = SecurityUtils.getPublicKey(pubData);
            return user;
        }
    }

    /**
     * Load user from file, deencript keys with password to verify if this is
     * correct
     *
     * @param userNumber
     * @param password
     * @return
     * @throws Exception
     */
    public static User load(String userNumber, String password) throws Exception {
        try {
            User user = load(userNumber);
            //Read files of keys
            byte[] pubData = Files.readAllBytes(Paths.get(USER_PATH + userNumber + ".pub"));
            byte[] privData = Files.readAllBytes(Paths.get(USER_PATH + userNumber + ".priv"));
            byte[] simData = Files.readAllBytes(Paths.get(USER_PATH + userNumber + ".sim"));
            //Make key with the data received

            user.pubKey = SecurityUtils.getPublicKey(pubData);
            //Desencript private key with password
            privData = SecurityUtils.decrypt(privData, password);
            user.privKey = SecurityUtils.getPrivateKey(privData);
            //Desencript simetric key with private key
            simData = SecurityUtils.decrypt(simData, user.privKey);
            user.key = SecurityUtils.getAESKey(simData);
            return user;

        } catch (Exception e) {
            System.out.println("RESET");
            throw new Exception("Login Data is Incorrect");
        }
    }

    public static List<User> getUserList() {
        List<User> lst = new ArrayList<>();
        //Read files from USER_PATH
        File[] files = new File(USER_PATH).listFiles();
        if (files == null) {
            return lst;
        }
        //Load the user to a list array
        for (File file : files) {
            //If its the user object file
            if (file.getName().endsWith(".user")) {
                //User id number
                String userNumber = file.getName().substring(0, file.getName().lastIndexOf("."));
                try {
                    lst.add(User.load(userNumber));
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Patient.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(User.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }

    /**
     * Return user from it's public key
     *
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static User getFromPublicKey(String publicKey) throws Exception {
        List<User> lst = getUserList();
        PublicKey pk = SecurityUtils.getPublicKey(
                Base64.getDecoder().decode(publicKey)
        );

        for (User user : lst) {
            if (user.getPubKey().equals(pk)) {
                return user;
            }
        }
        return null;
    }

    public InterfaceRemoteMiner getMiner() {
        return miner;
    }

    public void setMiner(InterfaceRemoteMiner miner) {
        this.miner = miner;
    }
}
