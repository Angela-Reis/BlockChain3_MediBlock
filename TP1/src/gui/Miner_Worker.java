/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingWorker;
import blockchain.Miner;

/**
 *
 * @author AR
 */
public class Miner_Worker extends SwingWorker<Integer, Integer> {

    MineInterface gui;

    AtomicInteger numberOfTerm;
    AtomicInteger nonce;
    int difficulty;
    String data;

    public Miner_Worker(MineInterface gui, int difficulty, String data) {
        this.gui = gui;
        //Distribuidor de trabalho - objecto partilhado
        numberOfTerm = new AtomicInteger();
        //objeto de calculo
        nonce = new AtomicInteger(0);
        //numero de iterações
        this.difficulty = difficulty;
        this.data = data;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        gui.onStart();
        System.out.println("DOING IN BACKGROUND");
        //Create threads to mine nonce
        int numProcessors = Runtime.getRuntime().availableProcessors();
        Miner[] thr = new Miner[numProcessors];
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new Miner(numberOfTerm, nonce, difficulty, data);
            thr[i].start();
        }
        while (numberOfTerm.get() < Miner.MAX_NONCE) {
            //update GPU
            publish(numberOfTerm.get());
            Thread.sleep(250);
        }
        return nonce.get();
    }

    @Override
    public void process(List<Integer> list) {
        gui.onUpdate(numberOfTerm.get());
    }

    @Override
    public void done() {
        gui.onFinish(nonce.get());
    }
}
