/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import blockchain.Block;
import blockchain.BlockChain;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to create the medical history over a blockchain
 * 
 * @author AR
 */
public class MedicalHistory {

    private static final long serialVersionUID = 02L; // serialization version
    public static int DIFICULTY = 1; // mining dificulty

    private final BlockChain history; // the blockchain itself

    public MedicalHistory() {
        history = new BlockChain();
    }

    public BlockChain getBlockChain() {
        return history;
    }

    /**
     * Get exam history
     * @return 
     */
    public List<Exam> getHistory() {
        List<Exam> hst = new ArrayList<>();
        for (Block b : history.getChain()) {
            Exam e = Exam.fromBase64(b.getData());
            hst.add(e);
        }
        return hst;
    }

    /**
     * Get user-filtered history
     * 
     * @param user
     * @return 
     */
    public List<Exam> getHistoryUser(User user) {
        List<Exam> hstUser = new ArrayList<>();
        for (Block b : history.getChain()) {
            Exam e = Exam.fromBase64(b.getData());
            if (e.getUtente().equals(user)) {
                hstUser.add(e);
            }
        }
        return hstUser;
    }

    /**
     * Method to add a block to the blockchain
     * 
     * @param e
     * @throws Exception 
     */
    public void add(Exam e) throws Exception {
        history.add(e.toBase64(), DIFICULTY);
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
    public static MedicalHistory load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (MedicalHistory) in.readObject();
        }
    }

}
