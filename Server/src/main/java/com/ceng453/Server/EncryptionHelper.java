package com.ceng453.Server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionHelper {

    public static String encrypt( String s ) throws NoSuchAlgorithmException {
        MessageDigest message_digest = MessageDigest.getInstance("MD5");
        byte[] digested_bytes = message_digest.digest(s.getBytes());
        StringBuffer hex_string = new StringBuffer();
        for(int i=0; i<digested_bytes.length; i++){
            hex_string.append(Integer.toHexString(0xff & digested_bytes[i]));
        }
        return hex_string.toString();
    }
}