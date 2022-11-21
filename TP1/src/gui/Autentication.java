/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.HealthProfessional;
import core.Patient;
import core.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Class to create Jframe to authentication
 * 
 * @author AR
 */
public class Autentication extends javax.swing.JFrame {

    /**
     * Creates new form Authorization
     */
    public Autentication() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMainAuth = new javax.swing.JTabbedPane();
        tabLogin = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPassLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        tabReg = new javax.swing.JPanel();
        txtRegPatPass = new javax.swing.JPasswordField();
        txtRegPatRepeatPass = new javax.swing.JPasswordField();
        txtRegPatNumber = new javax.swing.JTextField();
        txtRegPatBirth = new javax.swing.JFormattedTextField();
        txtRegPatSex = new javax.swing.JComboBox<>();
        btnRegisterPatient = new javax.swing.JButton();
        txtRegPatName = new javax.swing.JTextField();
        tabRegProf = new javax.swing.JPanel();
        txtRegProfPass = new javax.swing.JPasswordField();
        txtRegProfNum = new javax.swing.JTextField();
        txtRegProfRepeatPass = new javax.swing.JPasswordField();
        btnRegisterProfesional = new javax.swing.JButton();
        txtRegProfName = new javax.swing.JTextField();
        tabListPatients = new javax.swing.JScrollPane();
        listPatients = new javax.swing.JList<>();
        tabLstProf = new javax.swing.JScrollPane();
        listProfessionals = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbMainAuth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbMainAuthStateChanged(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder("User ID Number"));

        txtPassLogin.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtPassLogin.setToolTipText("");
        txtPassLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabLoginLayout = new javax.swing.GroupLayout(tabLogin);
        tabLogin.setLayout(tabLoginLayout);
        tabLoginLayout.setHorizontalGroup(
            tabLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(txtPassLogin)
                    .addComponent(txtUser))
                .addContainerGap())
        );
        tabLoginLayout.setVerticalGroup(
            tabLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLoginLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        tbMainAuth.addTab("Login", tabLogin);

        txtRegPatPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegPatPass.setToolTipText("");
        txtRegPatPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        txtRegPatRepeatPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegPatRepeatPass.setToolTipText("");
        txtRegPatRepeatPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Repeat Password"));

        txtRegPatNumber.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegPatNumber.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Number"));

        txtRegPatBirth.setBorder(javax.swing.BorderFactory.createTitledBorder("Date of Birth"));
        txtRegPatBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtRegPatBirth.setToolTipText("10/10/1990");
        txtRegPatBirth.setAutoscrolls(false);
        txtRegPatBirth.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N

        txtRegPatSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "F", "M" }));
        txtRegPatSex.setToolTipText("Sex");
        txtRegPatSex.setBorder(javax.swing.BorderFactory.createTitledBorder("Sex"));

        btnRegisterPatient.setText("Register Patient");
        btnRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterPatientActionPerformed(evt);
            }
        });

        txtRegPatName.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegPatName.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        javax.swing.GroupLayout tabRegLayout = new javax.swing.GroupLayout(tabReg);
        tabReg.setLayout(tabRegLayout);
        tabRegLayout.setHorizontalGroup(
            tabRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegisterPatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegPatRepeatPass, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(txtRegPatPass, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRegPatNumber)
                    .addComponent(txtRegPatBirth)
                    .addComponent(txtRegPatSex, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegPatName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        tabRegLayout.setVerticalGroup(
            tabRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRegPatName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegPatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegPatBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegPatSex, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegPatPass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegPatRepeatPass, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegisterPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        txtRegPatSex.getAccessibleContext().setAccessibleDescription("");

        tbMainAuth.addTab("Register Patient", tabReg);

        txtRegProfPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegProfPass.setToolTipText("");
        txtRegProfPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        txtRegProfNum.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegProfNum.setBorder(javax.swing.BorderFactory.createTitledBorder("Health Professional Lincense Number"));

        txtRegProfRepeatPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegProfRepeatPass.setToolTipText("");
        txtRegProfRepeatPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Repeat Password"));

        btnRegisterProfesional.setText("Register Health Professional");
        btnRegisterProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterProfesionalActionPerformed(evt);
            }
        });

        txtRegProfName.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtRegProfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        javax.swing.GroupLayout tabRegProfLayout = new javax.swing.GroupLayout(tabRegProf);
        tabRegProf.setLayout(tabRegProfLayout);
        tabRegProfLayout.setHorizontalGroup(
            tabRegProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRegProfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabRegProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRegProfNum, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(txtRegProfPass)
                    .addComponent(txtRegProfRepeatPass, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(btnRegisterProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegProfName))
                .addContainerGap())
        );
        tabRegProfLayout.setVerticalGroup(
            tabRegProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRegProfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRegProfName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegProfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegProfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegProfRepeatPass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        tbMainAuth.addTab("Register Professionals", tabRegProf);

        listPatients.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        listPatients.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listPatients.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPatientsValueChanged(evt);
            }
        });
        tabListPatients.setViewportView(listPatients);

        tbMainAuth.addTab("List of Patients", tabListPatients);

        listProfessionals.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        listProfessionals.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listProfessionals.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProfessionalsValueChanged(evt);
            }
        });
        tabLstProf.setViewportView(listProfessionals);

        tbMainAuth.addTab("List of Health Professionals", tabLstProf);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMainAuth)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbMainAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMainAuthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbMainAuthStateChanged
        // TODO add your handling code here:
        if (tbMainAuth.getSelectedComponent() == tabListPatients) {
            DefaultListModel model = new DefaultListModel();
            model.addAll(Patient.getPatientList());
            listPatients.setModel(model);
        } else if (tbMainAuth.getSelectedComponent() == tabLstProf) {
            DefaultListModel model = new DefaultListModel();
            model.addAll(HealthProfessional.getProfessionalsList());
            listProfessionals.setModel(model);
        }
    }//GEN-LAST:event_tbMainAuthStateChanged

    private void listProfessionalsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProfessionalsValueChanged
        if (listProfessionals.getSelectedIndex() >= 0) {
            HealthProfessional u = (HealthProfessional) listProfessionals.getSelectedValuesList().toArray()[0];
            txtUser.setText(u.getNumProfLicense());
            txtPassLogin.requestFocus();
            tbMainAuth.setSelectedComponent(tabLogin);
        }
    }//GEN-LAST:event_listProfessionalsValueChanged

    private void listPatientsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPatientsValueChanged
        // TODO add your handling code here:
        if (listPatients.getSelectedIndex() >= 0) {
            Patient u = (Patient) listPatients.getSelectedValuesList().toArray()[0];
            txtUser.setText(u.getNumPatient());
            txtPassLogin.requestFocus();
            tbMainAuth.setSelectedComponent(tabLogin);
        }
    }//GEN-LAST:event_listPatientsValueChanged

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            User user = User.load(txtUser.getText(), new String(txtPassLogin.getPassword()));
            this.dispose();
            new MedicalHistoryGUI(user).setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterPatientActionPerformed
        // TODO add your handling code here:
        if (txtRegPatBirth.getText().isBlank()
                || txtRegPatName.getText().isBlank()
                || txtRegPatNumber.getText().isBlank()
                || txtRegPatSex.getSelectedIndex() == 0
                || txtRegPatPass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all fields to create user", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Arrays.equals(txtRegPatPass.getPassword(), txtRegPatRepeatPass.getPassword())) {
            JOptionPane.showMessageDialog(this, "Passwords don't match");
            return;
        }
        LocalDate date = LocalDate.parse(txtRegPatBirth.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Patient patient = new Patient(txtRegPatName.getText(), date, txtRegPatNumber.getText(), txtRegPatSex.getSelectedItem().toString().charAt(0));

        try {
            User.register(patient, patient.getNumPatient(), new String(txtRegPatPass.getPassword()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterPatientActionPerformed

    private void btnRegisterProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProfesionalActionPerformed
        // TODO add your handling code here:
        if (txtRegProfName.getText().isBlank()
                || txtRegProfNum.getText().isBlank()
                || txtRegProfPass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all fields to create user", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Arrays.equals(txtRegPatPass.getPassword(), txtRegPatRepeatPass.getPassword())) {
            JOptionPane.showMessageDialog(this, "Passwords don't match");
            return;
        }

        HealthProfessional prof = new HealthProfessional(txtRegProfName.getText(), txtRegProfNum.getText());

        try {
            User.register(prof, prof.getNumProfLicense(), new String(txtRegPatPass.getPassword()));
        } catch (Exception ex) {
            Logger.getLogger(Autentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterProfesionalActionPerformed

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
            java.util.logging.Logger.getLogger(Autentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autentication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegisterPatient;
    private javax.swing.JButton btnRegisterProfesional;
    private javax.swing.JList<String> listPatients;
    private javax.swing.JList<String> listProfessionals;
    private javax.swing.JScrollPane tabListPatients;
    private javax.swing.JPanel tabLogin;
    private javax.swing.JScrollPane tabLstProf;
    private javax.swing.JPanel tabReg;
    private javax.swing.JPanel tabRegProf;
    private javax.swing.JTabbedPane tbMainAuth;
    private javax.swing.JPasswordField txtPassLogin;
    private javax.swing.JFormattedTextField txtRegPatBirth;
    private javax.swing.JTextField txtRegPatName;
    private javax.swing.JTextField txtRegPatNumber;
    private javax.swing.JPasswordField txtRegPatPass;
    private javax.swing.JPasswordField txtRegPatRepeatPass;
    private javax.swing.JComboBox<String> txtRegPatSex;
    private javax.swing.JTextField txtRegProfName;
    private javax.swing.JTextField txtRegProfNum;
    private javax.swing.JPasswordField txtRegProfPass;
    private javax.swing.JPasswordField txtRegProfRepeatPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
