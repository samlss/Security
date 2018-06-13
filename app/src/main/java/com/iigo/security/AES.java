package com.iigo.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/12 0012 17:14
 */

public class AES {
    private static final String CBC_PKCS1_PADDING = "AES/CBC/PKCS5Padding";//注意加密模式不要使用ECB模式。ECB模式不安全
    private static final String IPS = "c^Y!mrz7AYbQRriB"; //使用密码生成器生成

    private AES() {
    }

    public static byte[] generateKey(){
        byte[] key = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            return keyGenerator.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static byte[] encrypt(byte[] data, byte[] key){
        return doCipher(data, key, Cipher.ENCRYPT_MODE);
    }

    public static byte[] decrypt(byte[] data, byte[] key){
        return doCipher(data, key, Cipher.DECRYPT_MODE);
    }

    private static byte[] doCipher(byte[] data, byte[] key, int opmode){
        byte[] bytes = null;

        try {
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IPS.getBytes()); //使用CBC模式必须制定IvParameterSpec，且expected IV length of 16，即长度限制为16
            Cipher cipher = Cipher.getInstance(CBC_PKCS1_PADDING);
            cipher.init(opmode, secretKey, ivParameterSpec);

            bytes = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
