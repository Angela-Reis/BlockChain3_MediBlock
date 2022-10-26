/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author AR
 */
public class User implements Serializable{
    private final String nome;
    private final LocalDateTime dataNascimento;
    private final String numUtente;

    public User(String nome, LocalDateTime dataNascimento, String numUtente) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numUtente = numUtente;
    }
    
    public User(){
        this.nome = "";
        this.dataNascimento = LocalDateTime.now();
        this.numUtente = "";
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public String getNumUtente() {
        return numUtente;
    }
    
    
}
