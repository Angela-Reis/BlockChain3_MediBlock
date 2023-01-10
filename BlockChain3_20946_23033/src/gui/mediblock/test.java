/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mediblock;

import blockchain.p2p.InterfaceRemoteMiner;
import core.Analysis;
import core.Exam;
import core.HealthProfessional;
import core.Patient;
import core.Transaction;
import core.User;
import static gui.mediblock.MediBlockGUI.DIFICULTY;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myUtils.RMI;

/**
 *
 * @author AR
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

           // ArrayList<String> TRANSACTIONS = new ArrayList<>();

            // TODO code application logic here
            User user = User.load("1233", "123");
            InterfaceRemoteMiner remoteMiner = (InterfaceRemoteMiner) RMI.getRemote("//192.168.1.66:10010/miner");
            user.setMiner(remoteMiner);

            HealthProfessional prof = new HealthProfessional((HealthProfessional) user);
            List<Patient> lst = Patient.getPatientList();

            ArrayList<Analysis> analyses = new ArrayList<>();
            Analysis analysis = new Analysis("test1", "test1", "test1");
            analyses.add(analysis);
            Exam exam = new Exam(LocalDateTime.now(), (Patient) lst.get(1), prof, analyses);
            //Make a new Transaction to add to the blockChain
            Transaction transaction = new Transaction(exam, (HealthProfessional) user);
            user.getMiner().startMining(transaction.toBase64(), 4);

           // TRANSACTIONS.add(transaction.toBase64());

            analysis = new Analysis("1", "1", "1");
            analyses.add(analysis);
            exam = new Exam(LocalDateTime.now(), (Patient) lst.get(0), prof, analyses);
            transaction = new Transaction(exam, prof);
            //Health Professional signs the Transaction 
            transaction.sign(user.getPrivKey());
           // TRANSACTIONS.add(transaction.toBase64());
            user.getMiner().startMining(transaction.toBase64(), 4);

            analysis = new Analysis("2", "2", "2");
            analyses.add(analysis);
            exam = new Exam(LocalDateTime.now(), (Patient) lst.get(1), prof, analyses);
            transaction = new Transaction(exam, prof);
            //Health Professional signs the Transaction 
            transaction.sign(user.getPrivKey());
          //  TRANSACTIONS.add(transaction.toBase64());
            user.getMiner().startMining(transaction.toBase64(), 4);

            analysis = new Analysis("3", "3", "3");
            analyses.add(analysis);
            exam = new Exam(LocalDateTime.now(), (Patient) lst.get(0), prof, analyses);
            transaction = new Transaction(exam, prof);
            //Health Professional signs the Transaction 
            transaction.sign(user.getPrivKey());
          //  TRANSACTIONS.add(transaction.toBase64());
            user.getMiner().startMining(transaction.toBase64(), 4);

            analysis = new Analysis("4", "4", "4");
            analyses.add(analysis);
            exam = new Exam(LocalDateTime.now(), (Patient) lst.get(1), prof, analyses);
            transaction = new Transaction(exam, prof);
            //Health Professional signs the Transaction 
            transaction.sign(user.getPrivKey());
           // TRANSACTIONS.add(transaction.toBase64());
            user.getMiner().startMining(transaction.toBase64(), 4);

           // user.getMiner().startMining(TRANSACTIONS, 3);

        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
