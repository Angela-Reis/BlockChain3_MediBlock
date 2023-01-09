/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import blockchain.chain.Block;
import blockchain.chain.BlockChain;
import java.io.IOException;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Class to create the medical history over a blockchain
 *
 * @author AR
 */
public class MediBlock implements Serializable {

    private static final long serialVersionUID = 02L; // serialization version

    private BlockChain history; // the blockchain itself

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
            try {
                Transaction e = Transaction.fromBase64(b.getData());
                hst.add(e);
            } catch (IOException | ClassNotFoundException ex) {
            }
        }
        return hst;
    }

    /**
     * Get Exam history filtered by patientPubKeyStr get Transactions with
     * patientPubKeyStr decript the Exams and sends list with them
     *
     * @param patient
     * @param pk
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
            List<String> transactions = b.getTransactions();
            for (String t : transactions) {

                Transaction transaction;
                try {
                    transaction = Transaction.fromBase64(t);
                    if (transaction.getPatient().equals(patientPubKeyStr)) {
                        hstPatient.add(transaction.getDecodedExam(pk));
                    }
                } catch (IOException | ClassNotFoundException ex) {
                }
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
    public void add(Transaction t, int difficulty) throws Exception {
        history.add(t.toBase64(), difficulty);
    }


    public void setBlockChain(BlockChain blockChain) {
        history = blockChain;
    }

}
