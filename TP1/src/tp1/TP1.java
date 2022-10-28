/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Classes.Test;
import Classes.User;
import GUI.CreateTest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AR
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    
    private static void saveUser(User user) throws IOException {

        String nameOfFile = user.getNumUtente() + ".utente";
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        //==================SÓ PARA TESTE================== :):):)
        JFrame crtTestWin = new JFrame();
        crtTestWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        User user = new User();
        CreateTest crtTestGUI = new CreateTest(user);
        crtTestWin.setSize(crtTestGUI.getMinimumSize().width, crtTestGUI.getMinimumSize().height);
        crtTestGUI.setVisible(true);
        crtTestWin.add(crtTestGUI);
        crtTestWin.setVisible(true);
        
        
        /*User testUser = new User("Jota", LocalDateTime.now(), "23445");
        try {
            saveUser(testUser);
        } catch (IOException ex) {
            Logger.getLogger(TP1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
