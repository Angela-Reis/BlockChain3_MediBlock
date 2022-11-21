/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static core.User.USER_PATH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Class that represents the health professional
 * 
 * @author AR
 */
public class HealthProfessional extends User implements Serializable {

    private static final long serialVersionUID = 02L;

    private final String numProfLicense;

    public HealthProfessional(String name, String numProfLicense){
        super(name);
        this.numProfLicense = numProfLicense;
    }

    public String getNumProfLicense() {
        return numProfLicense;
    }

    

    public static List<HealthProfessional> getProfessionalsList() {
        List<User> lstUsers = User.getUserList();
        return lstUsers.stream()
                .filter(u -> u instanceof HealthProfessional)
                .map(u -> (HealthProfessional) u)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name + " - " + numProfLicense; //To change body of generated methods, choose Tools | Templates.
    }
}
