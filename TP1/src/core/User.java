/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import static core.MedicalHistory.load;
import gui.ReadExam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AR
 */
public class User implements Serializable {

    private static final long serialVersionUID = 02L;
    public static String USER_PATH = "utente/";

    private final String name;
    private final LocalDate dateOfBirth;
    private final String numUtente;

    public User(String nome, LocalDate dataNascimento, String numUtente) throws IOException {
        this.name = nome;
        this.dateOfBirth = dataNascimento;
        this.numUtente = numUtente;

        saveUser();

    }

    private void saveUser() throws IOException {
        File file = new File(USER_PATH);
        file.mkdirs();

        String nameOfFile = USER_PATH + numUtente + ".user";
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }

    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumUtente() {
        return numUtente;
    }

    private static User load(String username) throws FileNotFoundException, IOException, ClassNotFoundException {
        String path = USER_PATH + username + ".user";
        //load user from file 
        try (FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            User user = (User) ois.readObject();
            return user;
        }
    }

    public static List<User> getUserList() {
        List<User> lst = new ArrayList<>();
        //Ler os ficheiros da path dos utilizadores
        File[] files = new File(USER_PATH).listFiles();
        if (files == null) {
            return lst;
        }
        //contruir um user com cada ficheiros
        for (File file : files) {
            //se for uma chave publica
            if (file.getName().endsWith(".user")) {
                //nome do utilizador
                String userName = file.getName().substring(0, file.getName().lastIndexOf("."));
                try {
                    lst.add(load(userName));
                } catch (Exception e) {
                    System.out.println("Could not load file of" + userName);
                }
            }
        }
        return lst;
    }

    @Override
    public String toString() {
        return numUtente + " - " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof User)) {
            return false;
        }

        User userCompare = (User) obj;
        if (!userCompare.getNumUtente().equals(this.numUtente)) {
            return false;
        }
        if (!userCompare.getName().equals(this.name)) {
            return false;
        }
        return userCompare.getDateOfBirth().equals(this.dateOfBirth);

    }

}
