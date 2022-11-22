/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.Base64;
import utils.Serializer;

/**
 *
 * @author AR
 */
public class Test implements Serializable{
    private static final long serialVersionUID = 02L; // serialization version
    private String string;

    public Test() {
        string = "ola";
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
    public static Exam fromBase64(String b64) {

        byte[] data = Base64.getDecoder().decode(b64);
        return (Exam) Serializer.bytesToObject(data);
    }
}
