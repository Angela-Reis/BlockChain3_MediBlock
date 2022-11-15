/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.MedicalHistory;
import core.Patient;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author AR
 */
public class ExamHistory extends javax.swing.JFrame {

    public static String fileExamHistory = "ExamHistory.obj";
    Patient u;
    MedicalHistory history;
    CreateExam tabCreate;
    ReadExam tabRead;

    /**
     * Creates new form ExamHistory
     */
    public ExamHistory() {
        initComponents();
        listUsers.setSelectedIndex(0);
        //u = (Patient) listUsers.getSelectedValuesList().get(0);

        history = new MedicalHistory();
        try {
            history = MedicalHistory.load(fileExamHistory);
        } catch (IOException | ClassNotFoundException ex) {
        }
        if (listUsers.getSelectedIndex() >= 0) {
            tabCreate = new CreateExam(u, history, fileExamHistory);
            tabRead = new ReadExam(u, history, this);
            tabPane.add("Create", tabCreate);
            tabPane.add("Read", tabRead);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        scrlUsers = new javax.swing.JScrollPane();
        listUsers = new javax.swing.JList<>();
        createUser2 = new gui.CreateUser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        tabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPaneStateChanged(evt);
            }
        });

        listUsers.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "User1", "User2", "User3", "User4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUsersValueChanged(evt);
            }
        });
        scrlUsers.setViewportView(listUsers);

        tabPane.addTab("All Users", scrlUsers);
        tabPane.addTab("New User", createUser2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPaneStateChanged
        // TODO add your handling code here:
        if (tabPane.getSelectedComponent() == scrlUsers) {
            DefaultListModel model = new DefaultListModel();
            model.addAll(Patient.getUtenteList());
            listUsers.setModel(model);
        }
        if (tabPane.getSelectedComponent() == tabRead) {
            tabRead.UpdateExams(u);
        }
        if (tabPane.getSelectedComponent() == tabCreate) {
            tabCreate.UpdateUser(u);
        }
    }//GEN-LAST:event_tabPaneStateChanged

    private void listUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUsersValueChanged
        // TODO add your handling code here:
        if (listUsers.getSelectedIndex() >= 0) {
            u = (Patient) listUsers.getSelectedValuesList().get(0);
        }

        if (tabRead != null) {
            tabRead.UpdateExams(u);
        }
    }//GEN-LAST:event_listUsersValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExamHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.CreateUser createUser2;
    private javax.swing.JList<Object> listUsers;
    private javax.swing.JScrollPane scrlUsers;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
