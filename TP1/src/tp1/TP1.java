/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Classes.Analysis;
import Classes.Test;
import Classes.User;
import GUI.ReadTests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AR
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testSaving();
    }


    private static void testSaving() {
        ArrayList<Analysis> analyses = new ArrayList<>() {
            {
                add(new Analysis("Hematologia", "Eritrócitos", "4,55"));
                add(new Analysis("Hematologia", "Hemoglobina", "14,25"));
                add(new Analysis("Química Clínica", "Glicemia", "89"));
                add(new Analysis("Química Clínica", "Cretinia", "0,78"));
                add(new Analysis("Química Clínica", "Ácido Úrico", "4,1"));
                add(new Analysis("Hematologia", "Vol.Glob.médio", "87,70"));
            }
        };
        User user = new User("Joao Teste", LocalDate.of(1990, 10, 20), "992133");
        Test test1 = new Test(LocalDateTime.now(), user, "Ana Profissional", analyses);
        saveTest(test1);

        ArrayList<Analysis> analyses2 = new ArrayList<>() {
            {
                add(new Analysis("Hematologia", "Eritrócitos", "2,55"));
                add(new Analysis("Hematologia", "Hemoglobina", "15,25"));
                add(new Analysis("Química Clínica", "Glicemia", "98"));
                add(new Analysis("Química Clínica", "Cretinia", "0,74"));
                add(new Analysis("Química Clínica", "Ácido Úrico", "4,0"));
                add(new Analysis("Hematologia", "Vol.Glob.médio", "86,70"));
                
            }
        };
        Test test2 = new Test(LocalDateTime.of(LocalDate.of(2022, 10, 27), LocalTime.of(22, 12)), user, "Ana Profissional", analyses2);
        Test test3 = new Test(LocalDateTime.of(LocalDate.of(2022, 10, 17), LocalTime.of(20, 12)), user, "Ana Profissional", analyses);
        Test test4 = new Test(LocalDateTime.of(LocalDate.of(2021, 10, 17), LocalTime.of(20, 12)), user, "Ana Profissional", analyses);

        saveTest(test2);
        saveTest(test3);
        saveTest(test4);

        User user2 = new User("André Erro", LocalDate.of(1970, 10, 20), "111111");
        Test test5 = new Test(LocalDateTime.now(), user2, "Ana Profissional", analyses);
        saveTest(test5);

    }

    private static void saveTest(Test test) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");

        String nameOfFile = test.getUser().getNumUtente() + "_exame_"
                + test.getDateTest().format(formatter) + ".test";
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(test);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private User loadUser(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            User user = (User) ois.readObject();
            return user;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
