package com.iigo.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/12 0012 15:41
 */
public class DES3 {
    private DES3() {
    }


    public static byte[] generateKey(){
        byte[] key = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(56 * 3); //DES是一个基于56位密钥的对称的加密算法,而DES3其实是进行3次DES。
            key = keyGenerator.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return key;
    }

    /**
     * 加密
     *
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        return doCipher(data, key, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     *
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        return doCipher(data, key, Cipher.DECRYPT_MODE);
    }

    /**
     * 进行加密/解密
     *
     * @param data 原始数据
     * @param key 密钥
     * @param opmode 加密/解密{@link Cipher#ENCRYPT_MODE},{@link Cipher#DECRYPT_MODE}
     * */
    private static byte[] doCipher(byte[] data, byte[] key, int opmode){
        byte[] bytes = null;

        try {
            SecretKey secretKey = new SecretKeySpec(key, "DESede");

            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(opmode, secretKey);
            bytes = cipher.doFinal(data);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
