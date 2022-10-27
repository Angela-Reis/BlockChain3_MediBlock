/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Analysis;
import Classes.Test;
import Classes.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
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
public class ReadTests extends javax.swing.JPanel {
    
    User user;
    JFrame frame;

    /**
     * Creates new form VerExame
     *
     * @param f
     */
    public ReadTests(JFrame f) {
        frame = f;
        initComponents();
        user = new User("Joao Teste", LocalDate.of(1990, 10, 20), "992133");
        lblUtente.setText(lblUtente.getText() + " " + user.getNumUtente() + " " + user.getNome());
        //get all Test of the user
        ArrayList<File> userExams = searchForTestUser(user);

        //sort Test by date from newest to oldest
        userExams.sort((File o1, File o2) -> {
            //Name of file is in format numUtente_exame_ano_mes_dia_hora_minutos.test, remove .test
            String[] split1 = o1.getName().replace(".test", "").split("_");
            String[] split2 = o2.getName().replace(".test", "").split("_");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
            //Create String to turn into date
            String date1 = split1[2] + "_" + split1[3] + "_" + split1[4] + "_" + split1[5] + "_" + split1[6];
            String date2 = split2[2] + "_" + split2[3] + "_" + split2[4] + "_" + split2[5] + "_" + split2[6];
            LocalDateTime dateTime1 = LocalDateTime.parse(date1, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(date2, formatter);
            return dateTime2.compareTo(dateTime1);
        });
        GridBagConstraints c = new GridBagConstraints();
        int i = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (File exam : userExams) {
            Test test = loadTest(exam);
            if (test == null) {
                System.out.println("Error no Test Loaded");
            } else {
                i++;
                String text = test.getDateTest().format(formatter) + " " + test.getProfessional();
                c.gridy = i;
                c.ipadx = 10;
                c.weightx = 1;
                c.weighty = 1;
                c.anchor = GridBagConstraints.FIRST_LINE_START;
                c.gridx = 0;
                panelTestUser.add(new JLabel(test.getDateTest().format(formatter)), c);
                c.gridx = 1;
                panelTestUser.add(new JLabel(test.getProfessional()), c);
                c.gridx = 2;
                panelTestUser.add(new JLabel(String.valueOf(test.getAnalyses().size())), c);
                c.gridx = 3;
                JButton readTest = new JButton("Ver Exame");
                readTest.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        readTestBtn(test);
                    }
                    
                });
                panelTestUser.add(readTest, c);
            }
        }
        f.revalidate();
        setVisible(true);
    }
    
    private Test loadTest(File fileTest) {
        //load test from file 
        try (FileInputStream fis = new FileInputStream(fileTest.getName());
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Test test = (Test) ois.readObject();
            return test;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //search for test of the user 
    private ArrayList<File> searchForTestUser(User user) {
        File[] files = new File(".").listFiles();
        ArrayList<File> userFiles = new ArrayList<>();
        for (File f : files) {
            String fileName = f.getName();
            if (fileName.startsWith(user.getNumUtente()) && fileName.endsWith(".test")) {
                System.out.println(f.getName());
                userFiles.add(f);
            }
        }
        return userFiles;
    }
    
    private void readTestBtn(Test test) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String texto = "Nome: " + test.getUser().getNome();
        texto = texto + "\nNº Utente: " + test.getUser().getNumUtente();
        texto = texto + "\nData: " + test.getDateTest().format(formatter);
        texto = texto + "\nProfisional: " + test.getProfessional();
        texto = texto + "\n\nNome analise\t -\t Resultado";
        
        Collections.sort(test.getAnalyses());
        String type = test.getAnalyses().get(0).getTypeAnalysis();
        texto = texto + "\n\n\t" + type + "\n";
        for (Analysis analysis : test.getAnalyses()) {
            if (!type.equals(analysis.getTypeAnalysis())) {
                type = analysis.getTypeAnalysis();
                texto = texto + "\n\n\t" + type + "\n";
            }
            texto = texto + analysis.getName() + "\t-\t" + analysis.getResult() + "\n";
        }
        
        JPanel panel = new JPanel();
        JTextArea area = new JTextArea(texto);
        panel.setLayout(new BorderLayout());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(300, 300));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        panel.add(scroll);
        scroll.getHorizontalScrollBar().setValue(0);
        JOptionPane jop = new JOptionPane();
        jop.setPreferredSize(new Dimension(480, jop.getPreferredSize().height));
        jop.showMessageDialog(frame, panel, "Exame de " + test.getUser().getNumUtente(), JOptionPane.INFORMATION_MESSAGE);
        
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
            .addComponent(scrollShowEx)
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
                .addComponent(scrollShowEx))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


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
