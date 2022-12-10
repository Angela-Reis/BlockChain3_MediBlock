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

import java.io.Serializable;
import blockchain.miner.Miner;

/**
 * Created on 22/08/2022, 09:23:49
 * 
 * Block with consensus of Proof of Work
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Block implements Serializable {

    String previousHash; // link to previous block
    String data;         // data in the block
    int nonce;           // proof of work 
    String currentHash;  // Hash of block

    public Block(String previousHash, String data, int nonce) throws Exception {
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = nonce;
        this.currentHash = calculateHash();
    }

    public String calculateHash() throws Exception {
        return Miner.getHash(previousHash + data, nonce);
    }

    public String toString() {
        return // (isValid() ? "OK\t" : "ERROR\t")+
                 String.format("[ %8s", previousHash) + " <- " + 
                   String.format("%-10s", data) +  String.format(" %7d ] = ", nonce) + 
                String.format("%8s",currentHash);

    }

    public boolean isValid() throws Exception {
        return currentHash.equals(calculateHash());
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    public String getCurrentHash() {
        return currentHash;
    }
    
    public String getFullInfo(){
        return "Previous :\n\t " + previousHash+
                "\nData  :\n\t" + data+
                "\nNonce : " + nonce+
                "\nHash  :\n\t"+ currentHash;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202208220923L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2022  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}