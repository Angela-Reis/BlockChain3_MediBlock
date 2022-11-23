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
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package blockchain;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 28/09/2022, 11:13:39
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Miner extends Thread {

    AtomicInteger ticket;
    String zeros;
    AtomicInteger sharedNounce;    // shared object for nounce value 
    final String data;

    /**
     * Create a miner to getNonce() with multithreading
     * @param ticket
     * @param sharedNounce
     * @param difficulty
     * @param data 
     */
    public Miner(AtomicInteger ticket, AtomicInteger sharedNounce, int difficulty, String data) {
        this.ticket = ticket;
        this.sharedNounce = sharedNounce;
        this.zeros = String.format("%0" + difficulty + "d", 0);
        this.data = data;
    }

    @Override
    public void run() {
        //take a ticked with the term number
        int term;
        while ((term = ticket.getAndIncrement()) < MAX_NONCE) {
            try {

                if (Hash.getHash(term + data).startsWith(zeros)) {
                    sharedNounce.set(term);
                    ticket.set(MAX_NONCE);
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Calculate Nonce in a Parallel manner
     * @param diff
     * @param dat
     * @return
     * @throws Exception 
     */
    public static int getNoncePara(int diff, String dat) throws Exception {
        //Make algorithm for current computer
        int numProcessors = Runtime.getRuntime().availableProcessors();

        AtomicInteger ticket = new AtomicInteger(0);
        AtomicInteger nonce = new AtomicInteger(0);
        //array of Threads
        Miner[] thr = new Miner[numProcessors];
        //Make and run threads
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new Miner(ticket, nonce, diff, dat);
            thr[i].start();
        }
        //Wait for threads to end working
        int nonceSolved = 0;
        for (Miner thr1 : thr) {
            try {
                thr1.join();
                if (ValidateNonce(dat, thr1.sharedNounce.get(), diff)) {
                    nonceSolved = thr1.sharedNounce.get();
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //return nonce
        return nonceSolved;
    }

    //maximum number of Nonce
    public static int MAX_NONCE = (int) 1E9;

    //Class to callculate nounce 
    public static long calculateNounce(int digits) throws Exception {
        String d = "Dados para testar";
        long start = System.currentTimeMillis();
        int nValue = Miner.getNoncePara(digits, d);
        long time = System.currentTimeMillis() - start;
        System.out.println("Nounce = " + nValue);
        System.out.println("Hash final = " + Hash.getHash(nValue + d));
        return time;
    }

    public static void main(String[] args) {
        try {
            calculateNounce((int) 5);
        } catch (Exception ex) {
            Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Calculate nounce in a sequencial manner
     * @param data
     * @param dificulty
     * @return
     * @throws Exception 
     */
    public static int getNonce(String data, int dificulty) throws Exception {
        //String of zeros
        String zeros = String.format("%0" + dificulty + "d", 0);
        //starting nonce
        int nonce = 0;
        while (nonce < MAX_NONCE) {
            //calculate hash of block
            String hash = Hash.getHash(nonce + data);
            //Nounce found
            if (hash.startsWith(zeros)) {
                return nonce;
            }
            //next nounce
            nonce++;
        }
        return nonce;
    }

    /**
     * Check if the Nonce is the right one to hash the data with the difficulty
     * @param data
     * @param nonce
     * @param difficulty
     * @return
     * @throws Exception 
     */
    public static boolean ValidateNonce(String data, int nonce, int difficulty) throws Exception {
        String hash = Hash.getHash(nonce + data);
        return hash.startsWith(String.format("%0" + difficulty + "d", 0));
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202209281113L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2022  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
