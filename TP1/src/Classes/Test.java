/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AR
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 02L;
    private LocalDateTime dateTest;
    private User user;
    private String professional;
    private ArrayList<Analysis> analyses;

    public Test(LocalDateTime dateTest, User user, String professional, ArrayList<Analysis> analyses) {
        this.dateTest = dateTest;
        this.user = user;
        this.professional = professional;
        this.analyses = analyses;
    }

    public LocalDateTime getDateTest() {
        return dateTest;
    }

    public User getUser() {
        return user;
    }

    public String getProfessional() {
        return professional;
    }

    public ArrayList<Analysis> getAnalyses() {
        return analyses;
    }
}
