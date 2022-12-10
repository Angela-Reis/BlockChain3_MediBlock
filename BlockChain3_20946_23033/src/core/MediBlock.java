/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import blockchain.Block;
import blockchain.BlockChain;
import gui.parallel.MineInterface;
import gui.parallel.MinerWorker;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import p2p.miner.IminerRemoteP2P;

/**
 * Class to create the medical history over a blockchain
 *
 * @author AR
 */
public class MediBlock implements Serializable {

    private static final long serialVersionUID = 02L; // serialization version

    private final BlockChain history; // the blockchain itself

    public MediBlock() {
        history = new BlockChain();
    }

    public BlockChain getBlockChain() {
        return history;
    }

    /**
     * Get all transactions
     *
     * @return
     */
    public List<Transaction> getTransactions() {
        List<Transaction> hst = new ArrayList<>();
        for (Block b : history.getChain()) {
            Transaction e = Transaction.fromBase64(b.getData());
            hst.add(e);
        }
        return hst;
    }

    /**
     * Get Exam history filtered by patientPubKeyStr get Transactions with
     * patientPubKeyStr decript the Exams and sends list with them
     *
     * @param patient
     * @return
     * @throws java.lang.Exception
     */
    public List<Exam> getHistoryPatient(Patient patient, PrivateKey pk) throws Exception {
        if (pk == null || patient == null) {
            throw new Exception("The patient private key is necessary");
        }
        String patientPubKeyStr = Base64.getEncoder().encodeToString(patient.getPubKey().getEncoded());
        List<Exam> hstPatient = new ArrayList<>();
        for (Block b : history.getChain()) {
            //get Transaction
            Transaction transaction = Transaction.fromBase64(b.getData());
            if (transaction.getPatient().equals(patientPubKeyStr)) {
                hstPatient.add(transaction.getDecodedExam(pk));
            }
        }
        return hstPatient;
    }

    /**
     * Check if Transaction is Valid
     *
     * @param t
     * @return
     * @throws Exception
     */
    public boolean isValid(Transaction t) throws Exception {

        if (t.getPatient().trim().isEmpty()) {
            throw new Exception("Patient is empty");
        }
        if (t.getProfessional().trim().isEmpty()) {
            throw new Exception("Health Professional is empty");
        }
        if (t.getSignature().trim().isEmpty()) {
            throw new Exception("It's not signed by Health Professional");
        }
        return true;
    }

    /**
     * Method to add a block to the blockchain
     *
     * @param t
     * @param difficulty
     * @param nonce
     * @throws Exception
     */
    public void add(Transaction t, int nonce, int difficulty) throws Exception {
        history.add(t.toBase64(), nonce, difficulty);
    }

    public MinerWorker mineBlock(Transaction t, int difficulty, MineInterface gui, IminerRemoteP2P remoteMiner) throws Exception {
        if (isValid(t)) {
            return history.mineNonceWorker(t.toBase64(), difficulty, gui, remoteMiner);
        } else {
            throw new Exception("Transaction not valid");
        }
    }

    /**
     * Method to save the blockchain as an object
     *
     * @param fileName
     * @throws IOException
     */
    public void save(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    /**
     * Load the object representing the blockchain from memory
     *
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static MediBlock load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (MediBlock) in.readObject();
        }
    }

}
