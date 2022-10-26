/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;

/**
 *
 * @author AR
 */
public class User {
    private final String nome;
    private final Date dataNascimento;
    private final String numUtente;

    public User(String nome, Date dataNascimento, String numUtente) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numUtente = numUtente;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNumUtente() {
        return numUtente;
    }
    
    
}
