/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import blockchain.Block;
import blockchain.BlockChain;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AR
 */
public class MedicalHistory implements Serializable {

    private static final long serialVersionUID = 02L;
    public static int DIFICULTY = 1;

    private final BlockChain history;

    public MedicalHistory() {
        history = new BlockChain();
    }

    public BlockChain getBlockChain() {
        return history;
    }

    /**
     * Get exam history
     */
    public List<Exam> getHistory() {
        List<Exam> hst = new ArrayList<>();
        for (Block b : history.getChain()) {
            Exam e = Exam.fromBase64(b.getData());
            hst.add(e);
        }
        return hst;
    }

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

    public void add(Exam e) throws Exception {
        history.add(e.toBase64(), DIFICULTY);
    }

    public void save(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }

    public static MedicalHistory load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (MedicalHistory) in.readObject();
        }
    }

}
