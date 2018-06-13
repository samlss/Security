package com.iigo.security;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/12 0012 16:33
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    private SHA() {
    }

    public static String encrypt1(String data) {
        return encrypt(data, "SHA-1");
    }

    public static String encrypt224(String data) {
        return encrypt(data, "SHA-224");
    }

    public static String encrypt256(String data) {
        return encrypt(data, "SHA-256");
    }

    public static String encrypt384(String data) {
        return encrypt(data, "SHA-384");
    }

    public static String encrypt512(String data) {
        return encrypt(data, "SHA-512");
    }

    /**
     * 通过SHA加密
     *
     * @param data 原始数据
     * @param algorithm 算法(SHA-1，SHA-224，SHA-256，SHA-384，和SHA-512)
     */
    public static String encrypt(String data, String algorithm) {
       String result = null;

        try {
            byte[] dataBytes = data.getBytes();
            MessageDigest md5 = MessageDigest.getInstance(algorithm);
            md5.update(dataBytes);
            byte[] bytes = md5.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                if(Integer.toHexString(0xFF & b).length() == 1) {
                    sb.append("0").append(Integer.toHexString(0xFF & b));
                } else {
                    sb.append(Integer.toHexString(0xFF & b));
                }
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
