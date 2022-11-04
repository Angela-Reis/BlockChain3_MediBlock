/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static core.User.USER_PATH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AR
 */
public class Patient extends User {

    private final String numUtente;

    public Patient(String nome, LocalDate dataNascimento, String numUtente) throws IOException {
        super(nome, dataNascimento);
        this.numUtente = numUtente;
        saveUser();

    }

    public String getNumUtente() {
        return numUtente;
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

        Patient userCompare = (Patient) obj;
        if (!userCompare.getNumUtente().equals(this.numUtente)) {
            return false;
        }
        if (!userCompare.getName().equals(this.name)) {
            return false;
        }
        return userCompare.getDateOfBirth().equals(this.dateOfBirth);

    }

    @Override
    protected void saveUser() throws IOException {
        File file = new File(USER_PATH);
        file.mkdirs();

        String nameOfFile = USER_PATH + numUtente + ".user";
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }
    }

    private static Patient load(String username) throws FileNotFoundException, IOException, ClassNotFoundException {
        String path = USER_PATH + username + ".user";
        //load user from file 
        try (FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Patient user = (Patient) ois.readObject();
            return user;
        }
    }

    public static List<Patient> getUtenteList() {
        List<Patient> lst = new ArrayList<>();
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

}
