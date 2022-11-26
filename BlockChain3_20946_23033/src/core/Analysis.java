
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.Serializable;

/**
 * Class that defines an exam analysis
 * 
 * @author AR
 */
public class Analysis implements Serializable, Comparable<Analysis>{
    private static final long serialVersionUID = 02L; // version of serialization
    private final String typeAnalysis; // type of analysis
    private final String name; // Analysis' name
    private final String result; // Analysis' resuslt

    public Analysis(String tipeAnalysis, String name, String result) {
        this.typeAnalysis = tipeAnalysis;
        this.name = name;
        this.result = result;
    }

    public String getTypeAnalysis() {
        return typeAnalysis;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public int compareTo(Analysis o) {
        return typeAnalysis.compareTo(o.getTypeAnalysis());
    }

    /**
     * Convert the analysis to string with format 'typeAnalysis + " - " + name + " - " + result'
     * @return 
     */
    @Override
    public String toString() {
        return typeAnalysis + " - " + name + " - " + result; 
    }

}
