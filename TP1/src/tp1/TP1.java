/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Classes.User;
import GUI.CreateTest;
import javax.swing.JFrame;

/**
 *
 * @author AR
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //==================SÓ PARA TESTE================== :):):)
        JFrame crtTestWin = new JFrame();
        crtTestWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        crtTestWin.setSize(672, 347);
        
        User user = new User();
        CreateTest crtTestGUI = new CreateTest(user);
        crtTestGUI.setVisible(true);
        crtTestWin.add(crtTestGUI);
        crtTestWin.setVisible(true);
    }
    
}
