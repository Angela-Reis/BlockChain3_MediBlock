//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2021   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package gui.p2p;


import blockchain.chain.Block;
import blockchain.miner.Miner;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;
import myUtils.GuiUtils;
import myUtils.RMI;
import p2p.miner.ObjectRemoteMiner;
import p2p.miner.InterfaceRemoteMiner;
import p2p.miner.ListenerRemoteMiner;
import javax.swing.DefaultListModel;

/**
 *
 * @author IPT
 */
public class Remote_MinerBlockChain extends javax.swing.JFrame implements ListenerRemoteMiner {

    ObjectRemoteMiner miner = null;

    /**
     * Creates new form Test03_GUI_miner
     */
    public Remote_MinerBlockChain() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();
        tpMain = new javax.swing.JTabbedPane();
        pnServer = new javax.swing.JPanel();
        pnStartServer1 = new javax.swing.JPanel();
        pnNtework = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNetwork = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        txtServerAdress = new javax.swing.JTextField();
        btAddServer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btStartServer = new javax.swing.JButton();
        spMyServerPort = new javax.swing.JSpinner();
        txtAddress = new javax.swing.JTextField();
        pnMiner = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        spZeros = new javax.swing.JSpinner();
        txtNonce = new javax.swing.JTextField();
        txtHash = new javax.swing.JTextField();
        icon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        tpBlockchain = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtLeger = new javax.swing.JTextArea();
        pnBlockChain = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstBlockchain = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtBlock = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Miner (c) M@nso0 2022");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(64, 400));

        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        txtLog.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(txtLog);

        jSplitPane1.setRightComponent(jScrollPane2);

        pnServer.setLayout(new java.awt.BorderLayout());

        pnStartServer1.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
        pnServer.add(pnStartServer1, java.awt.BorderLayout.CENTER);

        pnNtework.setBorder(javax.swing.BorderFactory.createTitledBorder("NetWork"));

        txtNetwork.setColumns(20);
        txtNetwork.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtNetwork.setRows(5);
        jScrollPane3.setViewportView(txtNetwork);

        txtServerAdress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtServerAdress.setText("//10.10.209.111:10010/miner");
        txtServerAdress.setBorder(javax.swing.BorderFactory.createTitledBorder("Node Adress"));

        btAddServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockChain/gui/images/add-server-icon.png"))); // NOI18N
        btAddServer.setText("Add  Node");
        btAddServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btAddServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtServerAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtServerAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAddServer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnNteworkLayout = new javax.swing.GroupLayout(pnNtework);
        pnNtework.setLayout(pnNteworkLayout);
        pnNteworkLayout.setHorizontalGroup(
            pnNteworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnNteworkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );
        pnNteworkLayout.setVerticalGroup(
            pnNteworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNteworkLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnServer.add(pnNtework, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Miner Server"));

        btStartServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockChain/gui/images/start.png"))); // NOI18N
        btStartServer.setText("Start Server");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });

        spMyServerPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spMyServerPort.setModel(new javax.swing.SpinnerNumberModel(10010, 10010, null, 1));
        spMyServerPort.setBorder(javax.swing.BorderFactory.createTitledBorder("Port"));

        txtAddress.setEditable(false);
        txtAddress.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Address"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btStartServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spMyServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(394, Short.MAX_VALUE))
            .addComponent(txtAddress)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spMyServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnServer.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tpMain.addTab("Server", pnServer);

        pnMiner.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        spZeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spZeros.setModel(new javax.swing.SpinnerNumberModel(3, 2, null, 1));
        spZeros.setBorder(javax.swing.BorderFactory.createTitledBorder("Zeros"));
        spZeros.setEnabled(false);

        txtNonce.setEditable(false);
        txtNonce.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtNonce.setText("0");
        txtNonce.setBorder(javax.swing.BorderFactory.createTitledBorder("Nonce"));

        txtHash.setEditable(false);
        txtHash.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtHash.setText("0");
        txtHash.setBorder(javax.swing.BorderFactory.createTitledBorder("Hash"));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blockChain/gui/images/working.gif"))); // NOI18N
        icon.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spZeros, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNonce, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtHash))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spZeros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(txtNonce))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHash, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel1, java.awt.BorderLayout.NORTH);

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtMessage.setRows(5);
        txtMessage.setText("Hello GUI world!");
        txtMessage.setBorder(javax.swing.BorderFactory.createTitledBorder("Message"));
        txtMessage.setEnabled(false);
        jScrollPane1.setViewportView(txtMessage);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnMiner.add(jPanel7, java.awt.BorderLayout.WEST);

        tpMain.addTab("Miner", pnMiner);

        txtLeger.setColumns(20);
        txtLeger.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtLeger.setRows(5);
        jScrollPane4.setViewportView(txtLeger);

        tpBlockchain.addTab("Ledger", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/blockChain.png")), jScrollPane4); // NOI18N

        pnBlockChain.setLayout(new java.awt.BorderLayout());

        jScrollPane5.setPreferredSize(new java.awt.Dimension(200, 146));

        lstBlockchain.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lstBlockchain.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBlockchainValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstBlockchain);

        pnBlockChain.add(jScrollPane5, java.awt.BorderLayout.WEST);

        txtBlock.setEditable(false);
        txtBlock.setColumns(20);
        txtBlock.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtBlock.setLineWrap(true);
        txtBlock.setRows(5);
        txtBlock.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtBlock);

        pnBlockChain.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        tpBlockchain.addTab("BlockChainExplorer", new javax.swing.ImageIcon(getClass().getResource("/templarCoin/multimedia/Block.png")), pnBlockChain); // NOI18N

        tpMain.addTab("BlockChain", tpBlockchain);

        jSplitPane1.setLeftComponent(tpMain);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        try {
            int port = (Integer) spMyServerPort.getValue();
            miner = new ObjectRemoteMiner(port, this);
            RMI.startRemoteObject(miner, port, InterfaceRemoteMiner.NAME);
            txtAddress.setText(miner.getAdress());
            this.setTitle(miner.getAdress());
        } catch (Exception ex) {
            onException("Start Server", ex);
        }
    }//GEN-LAST:event_btStartServerActionPerformed

    private void btAddServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddServerActionPerformed
        try {
            miner.addNode((InterfaceRemoteMiner) RMI.getRemote(txtServerAdress.getText()));
        } catch (Exception ex) {
            onException("Add Server", ex);
        }
    }//GEN-LAST:event_btAddServerActionPerformed

    private void lstBlockchainValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBlockchainValueChanged
       if( lstBlockchain.getSelectedIndex() >=0){
           Block selected = (Block)lstBlockchain.getSelectedValues()[0];
           txtBlock.setText(selected.getFullInfo());
       }else{
           txtBlock.setText("");
       }
    }//GEN-LAST:event_lstBlockchainValueChanged

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
        } catch (Exception ex) {
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remote_MinerBlockChain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddServer;
    private javax.swing.JButton btStartServer;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList<String> lstBlockchain;
    private javax.swing.JPanel pnBlockChain;
    private javax.swing.JPanel pnMiner;
    private javax.swing.JPanel pnNtework;
    private javax.swing.JPanel pnServer;
    private javax.swing.JPanel pnStartServer1;
    private javax.swing.JSpinner spMyServerPort;
    private javax.swing.JSpinner spZeros;
    private javax.swing.JTabbedPane tpBlockchain;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtBlock;
    private javax.swing.JTextField txtHash;
    private javax.swing.JTextArea txtLeger;
    private javax.swing.JTextPane txtLog;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextArea txtNetwork;
    private javax.swing.JTextField txtNonce;
    private javax.swing.JTextField txtServerAdress;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onException(String title, Exception ex) {
        GuiUtils.insertText(txtLog, title, ex.getMessage(), Color.RED, Color.MAGENTA);
    }

    @Override
    public void onMessage(String title, String message) {
        GuiUtils.insertText(txtLog, title, message, Color.GREEN, Color.lightGray);
    }

    @Override
    public void onStartMining(String message, int zeros) {
        SwingUtilities.invokeLater(() -> {
            try {

                GuiUtils.insertText(txtLog, "Start Mining",
                        " " + message + "[" + zeros + "]", Color.GREEN, Color.WHITE);
                txtMessage.setText(miner.getMessage());
                txtHash.setText("");
                spZeros.setValue(zeros);
                icon.setVisible(true);
                icon.setEnabled(true);
                tpMain.setSelectedComponent(pnMiner);
                txtNonce.setBackground(Color.lightGray);
                txtHash.setBackground(Color.lightGray);
            } catch (RemoteException ex) {
                onException("Start Mining", ex);
            }
        });
    }

    @Override
    public void onStopMining(int nonce) {
        SwingUtilities.invokeLater(() -> {
            GuiUtils.insertText(txtLog, "Stop Mining", Thread.currentThread().getName());
            icon.setVisible(false);
            icon.setEnabled(false);
        });
    }

    @Override
    public void onMining(int number) {
        SwingUtilities.invokeLater(() -> {
            txtNonce.setText(number + "");
        });
    }

    @Override
    public void onNounceFound(int nonce) {
        //parar a rede de minar
        try {
            miner.stopMining(nonce);
            miner.addNewNode(nonce);
        } catch (RemoteException ex) {
            onException("Nounce Found", ex);
        }

        //atualizar a GUI
        SwingUtilities.invokeLater(() -> {
            GuiUtils.insertText(txtLog, "WINNER ", "\tFound nonce [ " + nonce + " ]", Color.GREEN, Color.MAGENTA);
            txtNonce.setText(nonce + "");
            txtHash.setText(Miner.getHash(txtMessage.getText(), nonce));
            icon.setEnabled(false);
            txtNonce.setBackground(Color.GREEN);
            txtHash.setBackground(Color.GREEN);
        });

    }

    @Override
    public void onStart(ObjectRemoteMiner rm) {
        SwingUtilities.invokeLater(() -> {
            GuiUtils.insertText(txtLog, "Server Start ", rm.getAdress(), Color.GREEN, Color.WHITE);
            btStartServer.setEnabled(false);
            tpMain.setSelectedComponent(pnMiner);
        });
    }

    @Override
    public void onAddNode(InterfaceRemoteMiner rm) {
        try {
            StringBuilder txt = new StringBuilder();
            for (InterfaceRemoteMiner m : miner.getNetwork()) {
                txt.append(m.getAdress() + "\n");
            }
            txtNetwork.setText(txt.toString().trim());
        } catch (RemoteException ex) {
            onException("AddNode", ex);
        }
    }

    @Override
    public void onSynchronizeChain(String title, String message) {
        SwingUtilities.invokeLater(() -> {
            GuiUtils.insertText(txtLog, title, message);
            updateBlockchain();
        });
    }

    @Override
    public void onAddNewBlock(String title, Block b) {
        SwingUtilities.invokeLater(() -> {
            GuiUtils.insertText(txtLog, title, b.getFullInfo());
            updateBlockchain();
        });
    }

    private void updateBlockchain() {
        try {
            DefaultListModel model = new DefaultListModel();
            model.addAll(miner.getBlockChain().getChain());
            lstBlockchain.setModel(model);
        } catch (RemoteException ex) {
            onException("Update List of Blocks", ex);
        }

    }

}
