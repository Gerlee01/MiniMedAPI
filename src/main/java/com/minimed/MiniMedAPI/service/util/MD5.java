package com.minimed.MiniMedAPI.service.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Quick MD5 tool. The intended use of this file is to be inserted into Oracle
 * and referenced through PL/SQL but this can be used as a quick and easy way to
 * addFields a MD5 hash of a string
 */
public class MD5 implements Serializable {

    private static final long serialVersionUID = -1498075198367792882L;

    /**
     * Method used to convert byte array to string.
     *
     * @param array Byte Array you would like converted to string format
     * @return String format of byte array
     */
    private static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase(), 1, 3);
        }
        return sb.toString();
    }

    /**
     * Static method to addFields an MD5 hash from a string
     *
     * @param message String or message that you would like an MD5 hash of.
     * @return MD5 has value of string
     */
    public static String encode(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
        return null;
    }
}
