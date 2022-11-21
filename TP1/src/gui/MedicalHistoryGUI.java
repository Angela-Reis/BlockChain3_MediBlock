/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Analysis;
import core.Exam;
import core.HealthProfessional;
import core.MedicalHistory;
import core.Patient;
import core.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author AR
 */
public class MedicalHistoryGUI extends javax.swing.JFrame {

    public static String fileExamHistory = "ExamHistory.obj";
    ArrayList<Analysis> analyses;

    User user;
    Patient patient;
    MedicalHistory history;

    /**
     * Creates new form ExamGUI
     *
     * @param user
     */
    public MedicalHistoryGUI(User user) {
        this.analyses = new ArrayList<>();
        this.user = user;
        //Load blockChain
        history = new MedicalHistory();
        try {
            history = MedicalHistory.load(fileExamHistory);
        } catch (IOException | ClassNotFoundException ex) {

        }

        /*Testing ------------------------------------
        try {
            //Testing
            this.user = User.load("1");//user Patient;
            //this.user = User.load("3");//user Professional;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicalHistoryGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MedicalHistoryGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        //----------------------------------------------
        initComponents();

        //this.user = user;
        if (user instanceof Patient) {
            listUserExams((Patient) user);
            System.out.println("PATIENT");
            tbExams.setSelectedComponent(tabReadHistory);
            int index = tbExams.indexOfComponent(tabCreateNew);
            tbExams.remove(index);
            index = tbExams.indexOfComponent(tabListPatients);
            tbExams.remove(index);
        } else if (user instanceof HealthProfessional) {
            System.out.println("HEALTH");
            txtProf.setText(user.toString());
            tbExams.setSelectedComponent(tabCreateNew);
            showPatientsCb();
        }
    }

    private void showPatientsCb() {
        List<Patient> lst = Patient.getPatientList();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(lst);
        cbPatients.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tbExams = new javax.swing.JTabbedPane();
        tabCreateNew = new javax.swing.JPanel();
        cbPatients = new javax.swing.JComboBox<>();
        txtProf = new javax.swing.JTextField();
        txtTipoAn = new javax.swing.JTextField();
        pnlStateExam = new javax.swing.JPanel();
        scrollShowEx = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSaveExam = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNameAn = new javax.swing.JTextField();
        btnAddAnalysis = new javax.swing.JButton();
        txtResAn = new javax.swing.JTextField();
        tabListPatients = new javax.swing.JScrollPane();
        listPatients = new javax.swing.JList<>();
        tabReadHistory = new javax.swing.JPanel();
        scrollShowEx1 = new javax.swing.JScrollPane();
        panelTestUser = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblUtente = new javax.swing.JLabel();
        panelHistoryHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        UserInformation = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbExams.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbExamsStateChanged(evt);
            }
        });

        cbPatients.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Patient"));

        txtProf.setEditable(false);
        txtProf.setBorder(javax.swing.BorderFactory.createTitledBorder("Health Professional"));

        txtTipoAn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTipoAn.setBorder(javax.swing.BorderFactory.createTitledBorder("Analysis Type"));
        txtTipoAn.setMinimumSize(new java.awt.Dimension(13, 55));
        txtTipoAn.setPreferredSize(new java.awt.Dimension(13, 50));

        pnlStateExam.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        scrollShowEx.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        scrollShowEx.setViewportView(jTextArea1);

        btnSaveExam.setText("Finalizar Exame");
        btnSaveExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveExamActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado Atual Exame");

        javax.swing.GroupLayout pnlStateExamLayout = new javax.swing.GroupLayout(pnlStateExam);
        pnlStateExam.setLayout(pnlStateExamLayout);
        pnlStateExamLayout.setHorizontalGroup(
            pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollShowEx, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addGroup(pnlStateExamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(btnSaveExam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStateExamLayout.setVerticalGroup(
            pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStateExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollShowEx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveExam)
                .addContainerGap())
        );

        txtNameAn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNameAn.setBorder(javax.swing.BorderFactory.createTitledBorder("Analysis Name"));
        txtNameAn.setMinimumSize(new java.awt.Dimension(13, 55));
        txtNameAn.setPreferredSize(new java.awt.Dimension(13, 55));

        btnAddAnalysis.setText("Add Analysis");
        btnAddAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnalysisActionPerformed(evt);
            }
        });

        txtResAn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtResAn.setBorder(javax.swing.BorderFactory.createTitledBorder("Analysis Results"));
        txtResAn.setMinimumSize(new java.awt.Dimension(13, 55));
        txtResAn.setPreferredSize(new java.awt.Dimension(13, 55));

        javax.swing.GroupLayout tabCreateNewLayout = new javax.swing.GroupLayout(tabCreateNew);
        tabCreateNew.setLayout(tabCreateNewLayout);
        tabCreateNewLayout.setHorizontalGroup(
            tabCreateNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCreateNewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCreateNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameAn, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoAn, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabCreateNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAddAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtResAn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(pnlStateExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        tabCreateNewLayout.setVerticalGroup(
            tabCreateNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCreateNewLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTipoAn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtResAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tabCreateNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStateExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbExams.addTab("Create New Exam", tabCreateNew);

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

        tbExams.addTab("Patients", tabListPatients);

        tabReadHistory.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTestUser.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("                ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.4;
        panelTestUser.add(jLabel5, gridBagConstraints);

        scrollShowEx1.setViewportView(panelTestUser);

        lblUtente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUtente.setText("Exams of Patient");

        panelHistoryHeader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        panelHistoryHeader.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        panelHistoryHeader.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Profesional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panelHistoryHeader.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("NºAnalises");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.4;
        panelHistoryHeader.add(jLabel8, gridBagConstraints);

        jLabel9.setText("                ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.4;
        panelHistoryHeader.add(jLabel9, gridBagConstraints);

        javax.swing.GroupLayout tabReadHistoryLayout = new javax.swing.GroupLayout(tabReadHistory);
        tabReadHistory.setLayout(tabReadHistoryLayout);
        tabReadHistoryLayout.setHorizontalGroup(
            tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReadHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollShowEx1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabReadHistoryLayout.createSequentialGroup()
                        .addGroup(tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUtente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHistoryHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addGap(10, 10, 10))
        );
        tabReadHistoryLayout.setVerticalGroup(
            tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReadHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(panelHistoryHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollShowEx1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbExams.addTab("Exam History", tabReadHistory);

        javax.swing.GroupLayout UserInformationLayout = new javax.swing.GroupLayout(UserInformation);
        UserInformation.setLayout(UserInformationLayout);
        UserInformationLayout.setHorizontalGroup(
            UserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        UserInformationLayout.setVerticalGroup(
            UserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        tbExams.addTab("User Information", UserInformation);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbExams, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbExams))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Autentication().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tbExamsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbExamsStateChanged
        // TODO add your handling code here:
        Component actual = tbExams.getSelectedComponent();
        if (actual == tabListPatients) {
            DefaultListModel model = new DefaultListModel();
            model.addAll(Patient.getPatientList());
            listPatients.setModel(model);
        } else if(actual == tabReadHistory && patient==null ){
            if(user instanceof Patient)
                return;
            JOptionPane.showMessageDialog(this, "Select a Patient", "Error", JOptionPane.ERROR_MESSAGE);
            tbExams.setSelectedComponent(tabListPatients);
        }
    }//GEN-LAST:event_tbExamsStateChanged

    private void listPatientsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPatientsValueChanged
        // TODO add your handling code here:
        if (listPatients.getSelectedIndex() >= 0) {
            this.patient = (Patient) listPatients.getSelectedValuesList().toArray()[0];
            listUserExams(patient);
            tbExams.setSelectedComponent(tabReadHistory);
        }
    }//GEN-LAST:event_listPatientsValueChanged

    private void btnAddAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnalysisActionPerformed
        //Variables inputed by the HealthProfessional
        String tipo = txtTipoAn.getText();
        String nome = txtNameAn.getText();
        String resultado = txtResAn.getText();
        Analysis analysis = new Analysis(tipo, nome, resultado);

        //if user logged in is a HealthProfessional
        if (user instanceof HealthProfessional) {
            //Verify is fields are empty
            if (txtNameAn.getText().isBlank() || txtResAn.getText().isBlank() || txtTipoAn.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            analyses.add(analysis);
            jTextArea1.setText(jTextArea1.getText() + "------ANÁLISE DE " + tipo.toUpperCase()
                + "(" + nome.toUpperCase() + ")------\n"
                + "RESULTADO: " + resultado + "\n"
                + "---------------------------------------------------\n");

        }
    }//GEN-LAST:event_btnAddAnalysisActionPerformed

    private void btnSaveExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveExamActionPerformed

        if (user instanceof HealthProfessional) {
            //Create new Exam
            Exam test = new Exam(LocalDateTime.now(), (Patient) cbPatients.getSelectedObjects()[0], (HealthProfessional) user, analyses);

            //Save new Exam
            try {
                if (!txtProf.getText().isBlank()) {
                    history.add(test);
                    history.save(fileExamHistory);
                } else {
                    JOptionPane.showMessageDialog(null, "Add Profesional");
                }
            } catch (Exception ex) {
                Logger.getLogger(MedicalHistoryGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtNameAn.setText("");
        txtTipoAn.setText("");
        txtResAn.setText("");
        txtProf.setText("");
        jTextArea1.setText("");
        this.analyses = new ArrayList<>();
    }//GEN-LAST:event_btnSaveExamActionPerformed

    /**
     * Loads the page and lists all the exams of an user
     */
    private void listUserExams(Patient patient) {
        panelTestUser.removeAll();
        lblUtente.setText("Exams of Patient " + patient.getName() + " Nº" + patient.getNumPatient());
        //get all Exam of the user
        if (patient == null) {
            return;
        }
        List<Exam> userExams = history.getHistoryPatient(patient);
        //sort Exam by date from newest to oldest
        userExams.sort((Exam o1, Exam o2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
            //Create String to turn into date
            String date1 = o1.getDateTest().format(formatter);
            String date2 = o2.getDateTest().format(formatter);
            LocalDateTime dateTime1 = LocalDateTime.parse(date1, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(date2, formatter);
            return dateTime2.compareTo(dateTime1);
        });

        GridBagConstraints c = new GridBagConstraints();
        int i = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (Exam exam : userExams) {
            if (exam != null) {
                i++;
                String text = exam.getDateTest().format(formatter) + " " + exam.getProfessional();
                c.gridy = i;
                c.ipadx = 10;
                c.weightx = 1;
                c.weighty = 1;
                c.anchor = GridBagConstraints.FIRST_LINE_START;
                c.gridx = 0;
                panelTestUser.add(new JLabel(exam.getDateTest().format(formatter)), c);
                c.gridx = 1;
                panelTestUser.add(new JLabel(exam.getProfessional().getName()), c);
                c.gridx = 2;
                panelTestUser.add(new JLabel(String.valueOf(exam.getAnalyses().size())), c);
                c.gridx = 3;
                JButton readExam = new JButton("Read Exam");
                readExam.addActionListener((ActionEvent e) -> {
                    readExamBtn(exam);
                });
                panelTestUser.add(readExam, c);
            }
        }
        revalidate();
    }

    /**
     * Action that shows an optionPane with the exam to String when the button
     * readExam, created in listUserExams, is pressed.
     *
     * @param exam
     */
    private void readExamBtn(Exam exam) {
        JPanel panel = new JPanel();
        JTextArea area = new JTextArea(exam.toString());
        panel.setLayout(new BorderLayout());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(300, 300));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        panel.add(scroll);
        JOptionPane.showMessageDialog(this, panel, "Exam of Patient " + exam.getUtente().toString(), JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
/*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MedicalHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicalHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicalHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicalHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
*/
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                  new MedicalHistoryGUI().setVisible(true);
//           }
//       });
//   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserInformation;
    private javax.swing.JButton btnAddAnalysis;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSaveExam;
    private javax.swing.JComboBox<String> cbPatients;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblUtente;
    private javax.swing.JList<String> listPatients;
    private javax.swing.JPanel panelHistoryHeader;
    private javax.swing.JPanel panelTestUser;
    private javax.swing.JPanel pnlStateExam;
    private javax.swing.JScrollPane scrollShowEx;
    private javax.swing.JScrollPane scrollShowEx1;
    private javax.swing.JPanel tabCreateNew;
    private javax.swing.JScrollPane tabListPatients;
    private javax.swing.JPanel tabReadHistory;
    private javax.swing.JTabbedPane tbExams;
    private javax.swing.JTextField txtNameAn;
    private javax.swing.JTextField txtProf;
    private javax.swing.JTextField txtResAn;
    private javax.swing.JTextField txtTipoAn;
    // End of variables declaration//GEN-END:variables
}
