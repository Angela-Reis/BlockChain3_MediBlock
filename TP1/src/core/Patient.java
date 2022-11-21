/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that represents the patient
 * 
 * @author AR
 */


public class Patient extends User implements Serializable {
    private static final long serialVersionUID = 02L;

    private final String numPatient;
    protected final LocalDate dateOfBirth;
    private final char sex;

    public Patient(String name, LocalDate dateOfBirth, String numUtente, char sex) {
        super(name);
        this.numPatient = numUtente;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumUtente() {
        return numPatient;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return name + " - " + numPatient;
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
        if (!userCompare.getNumUtente().equals(this.numPatient)) {
            return false;
        }
        if (!userCompare.getName().equals(this.name)) {
            return false;
        }
        return userCompare.getDateOfBirth().equals(this.dateOfBirth);

    }
    
    
    public static List<Patient> getPatientList(){
        List<User> lstUsers = User.getUserList();
        return lstUsers.stream()
                .filter(u -> u instanceof Patient)
                .map(u -> (Patient) u)
                .collect(Collectors.toList());
        
    }

}
