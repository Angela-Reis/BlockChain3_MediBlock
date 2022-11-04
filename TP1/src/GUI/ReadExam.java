/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Analysis;
import core.Exam;
import core.MedicalHistory;
import core.User;
import core.Patient;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author AR
 */
public class ReadExam extends javax.swing.JPanel {

    Patient user;
    JFrame frame;
    MedicalHistory history;

    public void UpdateExams(Patient user) {
        this.user = user;
        loadPage();
    }

    /**
     * Creates new form VerExame
     *
     * @param f
     * @param history
     * @param user
     */
    public ReadExam(Patient user, MedicalHistory history, JFrame f) {

        this.user = user;
        this.history = history;
        frame = f;
        initComponents();

        loadPage();


    }

    private void readTestBtn(Exam test) {
        JPanel panel = new JPanel();
        JTextArea area = new JTextArea(test.toString());
        panel.setLayout(new BorderLayout());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(300, 300));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        panel.add(scroll);
        JOptionPane.showMessageDialog(frame, panel, "Exame de " + test.getUtente().getNumUtente(), JOptionPane.INFORMATION_MESSAGE);

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

        jPanel1 = new javax.swing.JPanel();
        scrollShowEx = new javax.swing.JScrollPane();
        panelTestUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUtente = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTestUser.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        panelTestUser.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Profesional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panelTestUser.add(jLabel2, gridBagConstraints);

        jLabel3.setText("NºAnalises");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.4;
        panelTestUser.add(jLabel3, gridBagConstraints);

        jLabel4.setText("                ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.4;
        panelTestUser.add(jLabel4, gridBagConstraints);

        scrollShowEx.setViewportView(panelTestUser);

        lblUtente.setText("Exames do Utente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollShowEx, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUtente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollShowEx, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCabe() {
        JLabel lblDate = new javax.swing.JLabel();
        JLabel lblProf = new javax.swing.JLabel();
        JLabel lblNumAn = new javax.swing.JLabel();
        JLabel lblBtnRead = new javax.swing.JLabel();

        lblDate.setText("Data");
        GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 13;
        gbc.ipady = 2;
        gbc.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        panelTestUser.add(lblDate, gbc);

        lblProf.setText("Profesional");
        gbc = new java.awt.GridBagConstraints();
        gbc.ipadx = 18;
        gbc.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1.0;
        panelTestUser.add(lblProf, gbc);

        lblNumAn.setText("NºAnalises");
        gbc = new java.awt.GridBagConstraints();
        gbc.ipadx = 13;
        gbc.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1.0;
        gbc.weighty = 1.4;
        panelTestUser.add(lblNumAn, gbc);

        lblBtnRead.setText("                ");
        gbc = new java.awt.GridBagConstraints();
        gbc.ipadx = 13;
        gbc.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 1.0;
        gbc.weighty = 1.4;
        panelTestUser.add(lblBtnRead, gbc);
    }

    private void loadPage() {
        panelTestUser.removeAll();
        addCabe();
        lblUtente.setText("Exames do Utente " + user.getName() + " Nº" + user.getNumUtente());
        //get all Exam of the user
        if(user==null){
            return;
        }
        List<Exam> userExams = history.getHistoryUser(user);
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
                panelTestUser.add(new JLabel(exam.getProfessional()), c);
                c.gridx = 2;
                panelTestUser.add(new JLabel(String.valueOf(exam.getAnalyses().size())), c);
                c.gridx = 3;
                JButton readTest = new JButton("Ver Exame");
                readTest.addActionListener((ActionEvent e) -> {
                    readTestBtn(exam);
                });
                panelTestUser.add(readTest, c);
            }
        }
        frame.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUtente;
    private javax.swing.JPanel panelTestUser;
    private javax.swing.JScrollPane scrollShowEx;
    // End of variables declaration//GEN-END:variables

}
