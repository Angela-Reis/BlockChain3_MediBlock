/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author AR
 */
public class Analysis implements Serializable{
    private final String tipeAnalysis;
    private final String name;
    private final String result;

    public Analysis(String tipeAnalysis, String name, String result) {
        this.tipeAnalysis = tipeAnalysis;
        this.name = name;
        this.result = result;
    }

    public String getTipeAnalysis() {
        return tipeAnalysis;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

}
