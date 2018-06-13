package com.iigo.security;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/12 0012 17:58
 */

public class HMAC {
    private HMAC(){}

    public static String encrypt1(byte[] data, byte[] key){
        return encrypt(data, key, "HmacSHA1");
    }

    public static String encrypt224(byte[] data, byte[] key){
        return encrypt(data, key, "HmacSHA224");
    }

    public static String encrypt256(byte[] data, byte[] key){
        return encrypt(data, key, "HmacSHA256");
    }

    public static String encrypt384(byte[] data, byte[] key){
        return encrypt(data, key, "HmacSHA384");
    }

    public static String encrypt512(byte[] data, byte[] key){
       return encrypt(data, key, "HmacSHA512");
    }

    public static String encryptMD5(byte[] data, byte[] key){
        return encrypt(data, key, "HmacMD5");
    }

    /**
     * 通过HMAC加密
     *
     * @param data 原始数据
     * @param algorithm 算法(SHA-1，SHA-224，SHA-256，SHA-384，和SHA-512)
     */
    public static String encrypt(byte[] data, byte[] key, String algorithm) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(secretKey);
            mac.update(data);
            byte[] bytes = mac.doFinal();


            return Base64.encodeToString(bytes, Base64.NO_PADDING);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return null;
    }


}
