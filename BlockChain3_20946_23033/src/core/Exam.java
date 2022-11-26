/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import utils.Serializer;

/**
 * Class that represents the Exam
 *
 * @author AR
 */
public class Exam implements Serializable {

    private static final long serialVersionUID = 02L; // serialization version
    private LocalDateTime dateTest; // date of test
    private Patient patient; // patient whom the exam is preformed on
    private HealthProfessional professional; // professional that preforms the exam
    private ArrayList<Analysis> analyses; // Analysis of exam

    public Exam(LocalDateTime dateTest, Patient patient, HealthProfessional professional, ArrayList<Analysis> analyses) {
        this.dateTest = dateTest;
        this.patient = patient;
        this.professional = professional;
        this.analyses = analyses;
    }

    public LocalDateTime getDateTest() {
        return dateTest;
    }

    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public ArrayList<Analysis> getAnalyses() {
        return analyses;
    }

    /**
     * convert this object to base64
     *
     * @return
     */
    public String toBase64() {
        byte[] data = Serializer.objectToBytes(this);
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * make object from base64
     *
     * @param b64
     * @return
     */
    public static Exam fromBase64(String b64) {

        byte[] data = Base64.getDecoder().decode(b64);
        return (Exam) Serializer.bytesToObject(data);
    }

    /**
     * Convert the exam to string with format 'analysis.getName() + "\t-\t"+
     * analysis.getResult() + "\n"'
     *
     * @return
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        //order analyses by type
        Collections.sort(analyses);

        String texto = "Name: " + patient.getName();
        Period p = Period.between(patient.getDateOfBirth(), LocalDate.now());
        texto = texto + "\nAge: " + p.getYears();
        texto = texto + "\nPatient Nº: " + patient.getNumPatient();
        texto = texto + "\nDate of Exam: " + dateTest.format(formatter);
        texto = texto + "\nProfisional: " + professional;
        texto = texto + "\n\nName analysis\t -\t Result";
        String type = analyses.get(0).getTypeAnalysis();
        texto = texto + "\n\n\t" + type + "\n";
        for (Analysis analysis : analyses) {
            if (!type.equals(analysis.getTypeAnalysis())) {
                type = analysis.getTypeAnalysis();
                texto = texto + "\n\n\t" + type + "\n";
            }
            texto = texto + analysis.getName() + "\t-\t" + analysis.getResult() + "\n";
        }
        return texto;
    }

}
