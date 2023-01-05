/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import blockchain.chain.Block;
import p2p.miner.InterfaceRemoteMiner;
import core.Analysis;
import core.Exam;
import core.HealthProfessional;
import core.MediBlock;
import core.Patient;
import core.Transaction;
import core.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import myUtils.GuiUtils;

/**
 *
 * @author AR
 */
public class MediBlockGUI extends javax.swing.JFrame {

    public static String fileExamHistory = "ExamHistory.obj";
    public static int DIFICULTY = 3; // mining dificulty
    InterfaceRemoteMiner miner;
    //list of analyses currently inputed to the Exam being created
    ArrayList<Analysis> analyses;

    //Transaction being recorded to the blockchain 
    Transaction transaction;

    User user; //Current User
    Patient patient; //Patient the Health Professional is acessing
    MediBlock history; // Class that contains the blockchain

    /**
     * Creates new form ExamGUI
     *
     * @param user
     * @param remoteMiner
     */
    public MediBlockGUI(User user) {
        this.analyses = new ArrayList<>();
        this.user = user;
        this.miner = user.getMiner();
        //Create BlockChain 
        history = new MediBlock();
        try {
            //If there is a blockChain saved load it
            history.setBlockChain(user.getMiner().getBlockChain());

            new Thread(
                    () -> {
                        //codigo run da thread
                        while (true) {
                            try {
                                if(user.getMiner().isMining()==false){
                                    //if miner is not mining hide the progressBar
                                    panelMining.setVisible(false);
                                }
                                if (miner.getChainSize() > history.getBlockChain().getChain().size()) {
                                    history.setBlockChain(miner.getBlockChain());
                                    history.save(fileExamHistory);
                                    SwingUtilities.invokeLater(
                                            () -> {
                                                try {
                                                    tabMainStateChanged(null);
                                                    history.save(fileExamHistory);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                    );

                                }
                                Thread.sleep(1000);
                            } catch (Exception ex) {
                            }

                        }
                    }
            ).start();
            history = MediBlock.load(fileExamHistory);
        } catch (IOException | ClassNotFoundException ex) {
        }
        initComponents();

        //Insert Connection in Client Log and change the address textBox to the address of current miner
        try {
            GuiUtils.insertText(txtLog, "Connected ", miner.getAdress(), Color.GREEN, Color.MAGENTA);
        } catch (RemoteException ex) {
            Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Hide the panel with the loading interface
        panelMining.setVisible(false);
        //this.user = user;

        //Decide how the GUI appears depending on type of user
        if (user instanceof Patient) {
            listUserExams((Patient) user);
            tabMain.setSelectedComponent(tabReadHistory);
            //Patients don't have access to the page to create new exams
            int index = tabMain.indexOfComponent(tabCreateExam);
            tabMain.remove(index);
            //Patients don't have access to the page with the list of patients
            index = tabMain.indexOfComponent(tabListPatients);
            tabMain.remove(index);
        } else if (user instanceof HealthProfessional) {
            //load the professional to the txtProf field in the create new exams tab
            txtProf.setText(user.toString());
            tabMain.setSelectedComponent(tabCreateExam);
            //add patients to the comboBox in the create new Exams tab
            showPatientsCb();
        }

        spZeros.setValue(DIFICULTY);

        try {
            //load user information
            txtUserInfo.setText(user.getInfo());
        } catch (RemoteException ex) {
            Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtUserPriv.setText(Base64.getEncoder().encodeToString(
                user.getPrivKey().getEncoded()));
        txtUserPub.setText(Base64.getEncoder()
                .encodeToString(user.getPubKey().getEncoded()));
        txtUserSim.setText(Base64.getEncoder()
                .encodeToString(user.getKey().getEncoded()));
    }

    //Load Patients into comboBox
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

        panelMining = new javax.swing.JPanel();
        progressMine = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMain = new javax.swing.JTabbedPane();
        tabCreateExam = new javax.swing.JPanel();
        cbPatients = new javax.swing.JComboBox<>();
        txtProf = new javax.swing.JTextField();
        txtTypeAn = new javax.swing.JTextField();
        pnlStateExam = new javax.swing.JPanel();
        scrollShowEx = new javax.swing.JScrollPane();
        txtAnalyses = new javax.swing.JTextArea();
        btnSaveExam = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDeleteExam = new javax.swing.JButton();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUserInfo = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtUserPub = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtUserPriv = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtUserSim = new javax.swing.JTextArea();
        tabClient = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();
        spZeros = new javax.swing.JSpinner();
        tabBlock = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstBlockchain = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBlock = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMining.setMinimumSize(new java.awt.Dimension(300, 170));

        progressMine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        progressMine.setRequestFocusEnabled(false);
        progressMine.setString("Finding Nonce");
        progressMine.setStringPainted(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mining in Progress");
        jLabel1.setAutoscrolls(true);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        btnCancel.setText("Cancel Search");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMiningLayout = new javax.swing.GroupLayout(panelMining);
        panelMining.setLayout(panelMiningLayout);
        panelMiningLayout.setHorizontalGroup(
            panelMiningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMiningLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressMine, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMiningLayout.setVerticalGroup(
            panelMiningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMiningLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMiningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(progressMine, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        tabMain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabMainStateChanged(evt);
            }
        });

        cbPatients.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Patient"));
        cbPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPatientsActionPerformed(evt);
            }
        });

        txtProf.setEditable(false);
        txtProf.setBorder(javax.swing.BorderFactory.createTitledBorder("Health Professional"));

        txtTypeAn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTypeAn.setBorder(javax.swing.BorderFactory.createTitledBorder("Analysis Type"));
        txtTypeAn.setMinimumSize(new java.awt.Dimension(13, 55));
        txtTypeAn.setPreferredSize(new java.awt.Dimension(13, 50));

        pnlStateExam.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        scrollShowEx.setBackground(new java.awt.Color(255, 255, 255));

        txtAnalyses.setEditable(false);
        txtAnalyses.setColumns(20);
        txtAnalyses.setRows(5);
        scrollShowEx.setViewportView(txtAnalyses);

        btnSaveExam.setText("Finalize Exam");
        btnSaveExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveExamActionPerformed(evt);
            }
        });

        jLabel4.setText("State of Analysis in Exam");

        btnDeleteExam.setText("Delete Exam");
        btnDeleteExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStateExamLayout = new javax.swing.GroupLayout(pnlStateExam);
        pnlStateExam.setLayout(pnlStateExamLayout);
        pnlStateExamLayout.setHorizontalGroup(
            pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollShowEx, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlStateExamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStateExamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlStateExamLayout.createSequentialGroup()
                        .addComponent(btnSaveExam, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteExam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlStateExamLayout.setVerticalGroup(
            pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStateExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollShowEx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveExam)
                    .addComponent(btnDeleteExam))
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

        javax.swing.GroupLayout tabCreateExamLayout = new javax.swing.GroupLayout(tabCreateExam);
        tabCreateExam.setLayout(tabCreateExamLayout);
        tabCreateExamLayout.setHorizontalGroup(
            tabCreateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCreateExamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCreateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameAn, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTypeAn, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabCreateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAddAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtResAn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlStateExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabCreateExamLayout.setVerticalGroup(
            tabCreateExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCreateExamLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTypeAn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtResAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tabCreateExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStateExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMain.addTab("Create New Exam", tabCreateExam);

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

        tabMain.addTab("Patients", tabListPatients);

        tabReadHistory.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTestUser.setMinimumSize(new java.awt.Dimension(1, 1));
        panelTestUser.setName(""); // NOI18N
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
        lblUtente.setText("Exams of no Patient");

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
                    .addComponent(scrollShowEx1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabReadHistoryLayout.createSequentialGroup()
                        .addGroup(tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUtente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHistoryHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addGap(10, 10, 10))
        );
        tabReadHistoryLayout.setVerticalGroup(
            tabReadHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReadHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHistoryHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollShowEx1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMain.addTab("Exam History", tabReadHistory);

        txtUserInfo.setEditable(false);
        txtUserInfo.setColumns(20);
        txtUserInfo.setLineWrap(true);
        txtUserInfo.setRows(5);
        txtUserInfo.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtUserInfo);

        jTabbedPane1.addTab("Info", jScrollPane2);

        txtUserPub.setEditable(false);
        txtUserPub.setColumns(20);
        txtUserPub.setLineWrap(true);
        txtUserPub.setRows(5);
        txtUserPub.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtUserPub);

        jTabbedPane1.addTab("Public Key", jScrollPane5);

        txtUserPriv.setEditable(false);
        txtUserPriv.setColumns(20);
        txtUserPriv.setLineWrap(true);
        txtUserPriv.setRows(5);
        txtUserPriv.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtUserPriv);

        jTabbedPane1.addTab("Private Key", jScrollPane6);

        txtUserSim.setEditable(false);
        txtUserSim.setColumns(20);
        txtUserSim.setLineWrap(true);
        txtUserSim.setRows(5);
        txtUserSim.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtUserSim);

        jTabbedPane1.addTab("Simetric Key", jScrollPane7);

        javax.swing.GroupLayout UserInformationLayout = new javax.swing.GroupLayout(UserInformation);
        UserInformation.setLayout(UserInformationLayout);
        UserInformationLayout.setHorizontalGroup(
            UserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        UserInformationLayout.setVerticalGroup(
            UserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        tabMain.addTab("User Information", UserInformation);

        jScrollPane8.setPreferredSize(new java.awt.Dimension(64, 400));

        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtLog.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane8.setViewportView(txtLog);

        spZeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spZeros.setModel(new javax.swing.SpinnerNumberModel(3, 2, null, 1));
        spZeros.setBorder(javax.swing.BorderFactory.createTitledBorder("Zeros"));
        spZeros.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spZerosStateChanged(evt);
            }
        });

        javax.swing.GroupLayout tabClientLayout = new javax.swing.GroupLayout(tabClient);
        tabClient.setLayout(tabClientLayout);
        tabClientLayout.setHorizontalGroup(
            tabClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spZeros)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabClientLayout.setVerticalGroup(
            tabClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClientLayout.createSequentialGroup()
                .addComponent(spZeros, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMain.addTab("Client", tabClient);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 146));

        lstBlockchain.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lstBlockchain.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstBlockchain.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBlockchainValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstBlockchain);

        txtBlock.setEditable(false);
        txtBlock.setColumns(20);
        txtBlock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBlock.setLineWrap(true);
        txtBlock.setRows(5);
        txtBlock.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtBlock);

        javax.swing.GroupLayout tabBlockLayout = new javax.swing.GroupLayout(tabBlock);
        tabBlock.setLayout(tabBlockLayout);
        tabBlockLayout.setHorizontalGroup(
            tabBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabBlockLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabBlockLayout.setVerticalGroup(
            tabBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)))
        );

        tabMain.addTab("BlockChain", tabBlock);

        jScrollPane1.setViewportView(tabMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMining, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        dispose();
        new Authentication().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tabMainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabMainStateChanged
        // TODO add your handling code here:
        //Get currently selected tab
        Component actual = tabMain.getSelectedComponent();
        if (actual == tabListPatients) {
            //If the tab Selected is the user list load it
            DefaultListModel model = new DefaultListModel();
            model.addAll(Patient.getPatientList());
            listPatients.setModel(model);
        } else if (actual == tabReadHistory) {
            //If the user does not have access to the data of the Patient, leave
            if (!"Exams of no Patient".equals(lblUtente.getText())) {
                return;
            }
            //If there is no Patient Selected ask HealthProfessional to select a patient
            JOptionPane.showMessageDialog(this, "Select a Patient", "Error", JOptionPane.ERROR_MESSAGE);
            tabMain.setSelectedComponent(tabListPatients);
        } else if (actual == tabBlock) {
            //If the selected tab is the blockchain tab, load it with the blockChain data
            DefaultListModel model = new DefaultListModel();
            model.addAll(history.getBlockChain().getChain());
            lstBlockchain.setModel(model);

        }
    }//GEN-LAST:event_tabMainStateChanged

    private void listPatientsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPatientsValueChanged
        // TODO add your handling code here:
        //If a patient was selected
        if (listPatients.getSelectedIndex() >= 0) {
            this.patient = (Patient) listPatients.getSelectedValuesList().toArray()[0];
            String pass = inputPatientPassword(patient);
            if (pass != null) {

                try {
                    //load the patient with the private key
                    patient = (Patient) User.load(patient.getNumPatient(), pass);
                    listUserExams(patient);
                } catch (Exception ex) {
                    System.out.println("HI1");
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The Patient Password is required to Access this data",
                        "Error", JOptionPane.ERROR_MESSAGE);
                tabMain.setSelectedComponent(tabListPatients);
                return;
            }
            tabMain.setSelectedComponent(tabReadHistory);
        }
    }//GEN-LAST:event_listPatientsValueChanged

    private void btnAddAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnalysisActionPerformed
        //Variables inputed by the HealthProfessional
        String type = txtTypeAn.getText();
        String name = txtNameAn.getText();
        String result = txtResAn.getText();
        Analysis analysis = new Analysis(type, name, result);

        //if user logged in is a HealthProfessional
        if (user instanceof HealthProfessional) {
            //Verify is fields are empty
            if (txtNameAn.getText().isBlank() || txtResAn.getText().isBlank() || txtTypeAn.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            analyses.add(analysis);
            txtAnalyses.setText(txtAnalyses.getText()
                    + "------Analysis of " + type
                    + "(" + name + ")------\n"
                    + "Result: " + result + "\n"
                    + "---------------------------------------------------\n");

        }
    }//GEN-LAST:event_btnAddAnalysisActionPerformed

    private void btnSaveExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveExamActionPerformed
        //Check if the exam has at least one analusis
        if (analyses.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please add an anlysis to the Exam",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (user instanceof HealthProfessional) {
            //Make copy of Health Profesional without private and simetric keys
            HealthProfessional prof = new HealthProfessional((HealthProfessional) user);
            try {
                //Create new Exam
                Exam exam = new Exam(LocalDateTime.now(), (Patient) cbPatients.getSelectedObjects()[0], prof, analyses);
                //Make a new Transaction to add to the blockChain
                transaction = new Transaction(exam, (HealthProfessional) user);
                try {
                    //Check if connect to remote minerWorker
                    if (miner == null) {
                        JOptionPane.showMessageDialog(this, "Connect to a Server Before adding Block", "Error", JOptionPane.ERROR_MESSAGE);
                        tabMain.setSelectedComponent(tabClient);
                        return;
                    }
                    startProgressBar();
                    //Ask the blockchain to start the thread with the correct data, from the transaction
                    user.getMiner().startMining(transaction.toBase64(), DIFICULTY);
                    history.save(fileExamHistory);
                } catch (Exception ex) {
                    Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                cleanNewExamTab();
            } catch (Exception ex) {
                Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Only Health Professionals can add Exams", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveExamActionPerformed

    private void cbPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPatientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPatientsActionPerformed

    private void lstBlockchainValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBlockchainValueChanged
        if (lstBlockchain.getSelectedIndex() >= 0) {
            Block b = (Block) lstBlockchain.getSelectedValuesList().toArray()[0];
            txtBlock.setText(b.getFullInfo());
        }
    }//GEN-LAST:event_lstBlockchainValueChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //Confirm is user really wants to cancel the nonce search
        int option = JOptionPane.showConfirmDialog(this,
                "IF Canceled the Exam will be deleted",
                "Warning Cancel",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                endProgressBar();
                //stops mining in all the remote servers
                miner.stopMining(9999);
            } catch (RemoteException ex) {
                Logger.getLogger(MediBlockGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExamActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this,
                "Do you want to delete the current Exam?",
                "Warning Delete",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            cleanNewExamTab();
        }
    }//GEN-LAST:event_btnDeleteExamActionPerformed

    private void spZerosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spZerosStateChanged
        // TODO add your handling code here:
        DIFICULTY = (int) spZeros.getValue();
    }//GEN-LAST:event_spZerosStateChanged

    private void cleanNewExamTab() {
        //Erase all fields from the Create New Exams Tab
        txtNameAn.setText("");
        txtTypeAn.setText("");
        txtResAn.setText("");
        txtAnalyses.setText("");
        this.analyses = new ArrayList<>();
    }

    /**
     * Ask for Patient password Only the professionals the patients give the
     * password to can access their history Since the private key of the patient
     * is needed to Access the data
     *
     * @param p
     * @return
     */
    private String inputPatientPassword(Patient p) {
        JPanel panel = new JPanel();

        panel.setBounds(61, 11, 81, 140);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter " + p.toString() + " Password to View Exams");
        JPasswordField pass = new JPasswordField();
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Access Denied",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        if (option == 0) {
            return new String(pass.getPassword());
        }
        return null;
    }

    /**
     * Loads the tabReadHistory and lists all the exams of an user
     *
     * @param patient
     */
    private void listUserExams(Patient patient) {
        try {
            if (patient == null) {
                return;
            }
            panelTestUser.removeAll();
            lblUtente.setText("Exams of Patient " + patient.getName() + " Nº" + patient.getNumPatient());
            List<Exam> userExams = history.getHistoryPatient(patient, patient.getPrivKey());

            userExams = history.getHistoryPatient(patient, patient.getPrivKey());
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
        } catch (Exception ex) {
            Logger.getLogger(MediBlock.class.getName()).log(Level.ALL, null, ex);
           // JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        JOptionPane.showMessageDialog(this, panel, "Exam of Patient " + exam.getPatient().toString(), JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Show the progressBar to show remote miner is mining
     */
    public void startProgressBar() {
        panelMining.setVisible(true);
        progressMine.setIndeterminate(true);
    }

    /**
     * Hide the progressBar to show remote miner is not mining
     */
    public void endProgressBar() {
        panelMining.setVisible(false);
        progressMine.setIndeterminate(false);
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
            java.util.logging.Logger.getLogger(MediBlockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediBlockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediBlockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediBlockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
     */
 /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                  new MediBlockGUI().setVisible(true);
//           }
//       });
//   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserInformation;
    private javax.swing.JButton btnAddAnalysis;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteExam;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSaveExam;
    private javax.swing.JComboBox<String> cbPatients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUtente;
    private javax.swing.JList<String> listPatients;
    private javax.swing.JList<String> lstBlockchain;
    private javax.swing.JPanel panelHistoryHeader;
    private javax.swing.JPanel panelMining;
    private javax.swing.JPanel panelTestUser;
    private javax.swing.JPanel pnlStateExam;
    private javax.swing.JProgressBar progressMine;
    private javax.swing.JScrollPane scrollShowEx;
    private javax.swing.JScrollPane scrollShowEx1;
    private javax.swing.JSpinner spZeros;
    private javax.swing.JPanel tabBlock;
    private javax.swing.JPanel tabClient;
    private javax.swing.JPanel tabCreateExam;
    private javax.swing.JScrollPane tabListPatients;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JPanel tabReadHistory;
    private javax.swing.JTextArea txtAnalyses;
    private javax.swing.JTextArea txtBlock;
    private javax.swing.JTextPane txtLog;
    private javax.swing.JTextField txtNameAn;
    private javax.swing.JTextField txtProf;
    private javax.swing.JTextField txtResAn;
    private javax.swing.JTextField txtTypeAn;
    private javax.swing.JTextArea txtUserInfo;
    private javax.swing.JTextArea txtUserPriv;
    private javax.swing.JTextArea txtUserPub;
    private javax.swing.JTextArea txtUserSim;
    // End of variables declaration//GEN-END:variables
}
