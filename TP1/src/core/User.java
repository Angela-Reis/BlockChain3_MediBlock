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
public abstract class User implements Serializable {

    private static final long serialVersionUID = 02L;
    public static String USER_PATH = "utente/";

    protected final String name;
    protected final LocalDate dateOfBirth;

    public User(String nome, LocalDate dataNascimento) throws IOException {
        this.name = nome;
        this.dateOfBirth = dataNascimento;
    }

    protected abstract void saveUser() throws IOException;

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

}
