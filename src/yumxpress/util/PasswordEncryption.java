/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

import java.util.Base64;

/**
 *
 * @author harsh
 */
public class PasswordEncryption {

    public static String getEncryptedPassword(String pwd) {
        Base64.Encoder en = Base64.getEncoder();
        String encryptedPwd = en.encodeToString(pwd.getBytes());
        return encryptedPwd;
    }

    public static String getDecryptedPassword(String pwd) {
        Base64.Decoder dec = Base64.getDecoder();
        byte[] arr = dec.decode(pwd.getBytes());
        String decryptedPwd = new String(arr);
        return decryptedPwd;
    }
}
