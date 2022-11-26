/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import utils.SecurityUtils;
import utils.Serializer;

/**
 * Class that defines the Transaction that goes into the blockchain
 * @author AR
 */
public class Transaction implements Serializable{
    private static final long serialVersionUID = 02L; // serialization version
    private final String professional;
    private final String patient;
    private final byte[] encryptedExam;
    private final byte[] encryptedAES; // a randomly generated AES Key
    String signature;     //signature of Professional

    public Transaction(Exam exam, HealthProfessional prof) throws Exception {
        if (exam.getProfessional().getPubKey() != prof.getPubKey()) {
            throw new Exception("Professionals don't match");
        }
        
        //turn the professional and the patients public keys into Strings
        this.professional = Base64.getEncoder().encodeToString(exam.getProfessional().getPubKey().getEncoded());
        this.patient = Base64.getEncoder().encodeToString(exam.getPatient().getPubKey().getEncoded());

        //check if exam is null
        if (exam == null) {
            throw new Exception("Exam can not be null");
        }

        //turn Exam into a byte[]
        byte[] originalExam = Serializer.objectToBytes(exam);

        //Since the Exam is too long to encrypt with RSA Key it was encrypted with a random AES 
        Key randomAESKey = SecurityUtils.generateAESKey(User.SIZE_AES_KEY);
        this.encryptedExam = SecurityUtils.encrypt(originalExam, randomAESKey);

        //This AES Key is then encrypted with the RSA Algorithm and saved to later decrypt the exam
        this.encryptedAES = SecurityUtils.encrypt(randomAESKey.getEncoded(), exam.getPatient().getPubKey());

        //Health Professional signs the Transaction 
        sign(prof.getPrivKey());

    }

    /**
     * Decode the encryptedExam
     * @param pkPatient
     * @return
     * @throws Exception 
     */
    public Exam getDecodedExam(PrivateKey pkPatient) throws Exception {
        //decrypt the AES key with the patient private key
        byte[] arrKey = SecurityUtils.decrypt(encryptedAES, pkPatient);
        //turn it back into a key
        Key AESKey = SecurityUtils.getAESKey(arrKey);
        //decrypt the exam with the AES Key
        Exam examDecrypted = (Exam) Serializer.bytesToObject(SecurityUtils.decrypt(encryptedExam, AESKey));
        return examDecrypted;
    }

    public final void sign(PrivateKey priv) throws Exception {
        byte[] data = (professional + patient + encryptedExam).getBytes();
        byte[] s = SecurityUtils.sign(data, priv);
        signature = Base64.getEncoder().encodeToString(s);
    }

    public boolean validateSignature() throws Exception {
        //Transaction Data
        byte[] data = (professional + patient + encryptedExam).getBytes();
        //Sign data
        byte[] sign = Base64.getDecoder().decode(signature);
        //Public Key of professional
        byte[] pk = Base64.getDecoder().decode(professional);
        PublicKey pubKey = SecurityUtils.getPublicKey(pk);
        return SecurityUtils.verifySign(data, sign, pubKey);
    }

    public String getProfessional() {
        return professional;
    }

    public String getPatient() {
        return patient;
    }


    public String getSignature() {
        return signature;
    }

    /**
     * convert this object to base64
     *
     * @return
     */
    public String toBase64() {
        byte[] data = Serializer.objectToBytes(this);
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * make object from base64
     *
     * @param b64
     * @return
     */
    public static Transaction fromBase64(String b64) {

        byte[] data = Base64.getDecoder().decode(b64);
        return (Transaction) Serializer.bytesToObject(data);
    }

}
