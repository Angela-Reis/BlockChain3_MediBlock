/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author AR
 */
public class User implements Serializable{
    private static final long serialVersionUID = 02L;
    private final String nome;
    private final LocalDate dataNascimento;
    private final String numUtente;

    public User(String nome, LocalDate dataNascimento, String numUtente) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numUtente = numUtente;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNumUtente() {
        return numUtente;
    }
    
    
}
