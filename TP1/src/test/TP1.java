/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import core.Analysis;
import core.Exam;
import core.User;
import gui.CreateExam;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AR
 */
public class TP1 {

   /* public static void main(String[] args) {
        //==================SÓ PARA TESTE================== :):):)
        JFrame crtTestWin = new JFrame();
        crtTestWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            User user = new User("Jota", LocalDate.now(), "23445");
            CreateExam crtTestGUI = new CreateExam(user);
            crtTestWin.setSize(crtTestGUI.getMinimumSize().width, crtTestGUI.getMinimumSize().height);
            crtTestGUI.setVisible(true);
            crtTestWin.add(crtTestGUI);
            crtTestWin.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TP1.class.getName()).log(Level.SEVERE, null, ex);
        }

        //testSaving();
        User testUser = new User("Jota", LocalDate.now(), "23445");
        try {
            saveUser(testUser);
        } catch (IOException ex) {
            Logger.getLogger(TP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}
