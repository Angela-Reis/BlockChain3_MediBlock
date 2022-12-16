/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.parallel;

import p2p.miner.InterfaceRemoteMiner;
import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingWorker;

/**
 *
 * @author AR
 */
public class MinerWorker extends SwingWorker<Integer, Integer> {

    MineInterface gui;

    AtomicInteger numberOfTerm;
    AtomicInteger nonce;
    int difficulty;
    String data;
    InterfaceRemoteMiner remoteMiner;

    public MinerWorker(MineInterface gui, int difficulty, String data, InterfaceRemoteMiner remoteMiner) {
        this.gui = gui;
        //Distribuidor de trabalho - objecto partilhado
        numberOfTerm = new AtomicInteger();
        //objeto de calculo
        nonce = new AtomicInteger(0);
        //numero de iterações
        this.difficulty = difficulty;
        this.data = data;
        this.remoteMiner = remoteMiner;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        gui.onStart();
//        //Create threads to mine nonce
//        int numProcessors = Runtime.getRuntime().availableProcessors();
//        Miner[] thr = new Miner[numProcessors];
//        for (int i = 0; i < thr.length; i++) {
//            thr[i] = new Miner(numberOfTerm, nonce, difficulty, data);
//            thr[i].start();
//        }
//        while (numberOfTerm.get() < Miner.MAX_NONCE) {
//            //update GPU
//            publish(numberOfTerm.get());
//            Thread.sleep(250);
//        }//192.168.1.143:10010/miner
//        return nonce.get();
        try {
            int n = remoteMiner.mine(data, difficulty);
            nonce.set(n);

        } catch (RemoteException x) {
            x.printStackTrace();
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
