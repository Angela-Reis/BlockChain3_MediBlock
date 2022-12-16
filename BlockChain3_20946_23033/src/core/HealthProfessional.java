/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that represents the health professional
 * 
 * @author AR
 */
public class HealthProfessional extends User implements Serializable {

    private static final long serialVersionUID = 04L;

    private final String numProfLicense;

    public HealthProfessional(String name, String numProfLicense) {
        super(name);
        this.numProfLicense = numProfLicense;
    }

    /**
     * Create a copy of HealthProfessional, without private and simetric key
     * @param prof 
     */
    public HealthProfessional(HealthProfessional prof) {
        super(prof.name);
        this.numProfLicense = prof.numProfLicense;
        this.pubKey = prof.getPubKey();
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
    public String getInfo() throws RemoteException {
        StringBuilder txt = new StringBuilder();
        txt.append("Health Professional Information");
        txt.append("\nName  : " + name);
        txt.append("\nProfesional License Nº :" + numProfLicense);
        return txt.append(super.getInfo()).toString(); 
    }

    @Override
    public String toString() {
        return name + " - License nº" + numProfLicense; 
    }
}
