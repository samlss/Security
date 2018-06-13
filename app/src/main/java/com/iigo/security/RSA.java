package com.iigo.security;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/11 0011 12:08
 */

public class RSA {

    public static final String RSA = "RSA";// 非对称加密密钥算法
    public static final String ECB_PADDING = "RSA/ECB/PKCS1Padding";//加密填充方式
//    public static final String ECB_PADDING = "RSA/ECB/OAEPWithSHA256AndMGF1Padding";//加密填充方式

    /**
     * RSA算法规定：待加密的字节数不能超过密钥的长度值除以8再减去11。
     *
     * 而加密后得到密文的字节数，正好是密钥的长度值除以 8。
     * */
    private static int KEYSIZE = 2048;// 密钥位数
    private static int RESERVE_BYTES = 11;// 加密block需要预留字节数
    private static int DECRYPT_BLOCK = KEYSIZE / 8; // 每段解密block数，256 bytes
    private static int ENCRYPT_BLOCK = DECRYPT_BLOCK - RESERVE_BYTES; // 每段加密block数245bytes

    /**
     * 随机生成RSA密钥对
     *
     * @param keysize 密钥长度，范围：512-2048,一般2048
     */
    public static KeyPair generateKeyPair(int keysize) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA);
            kpg.initialize(keysize);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用公钥对字符串进行加密
     *
     * @param data 原文
     */
    public static byte[] encryptWithPublicKey(byte[] data, byte[] key)
            throws Exception {
        Cipher cp = Cipher.getInstance(ECB_PADDING);
        cp.init(Cipher.ENCRYPT_MODE, getPublicKey(key));
        return cp.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param key 密钥
     */
    public static byte[] decryptWithPublicKey(byte[] data, byte[] key)
            throws Exception {
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, getPublicKey(key));
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key 密钥
     */
    public static byte[] encryptWithPrivateKey(byte[] data, byte[] key)
            throws Exception {
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, getPrivateKey(key));
        return cipher.doFinal(data);
    }


    /**
     * 私钥解密
     *
     * @param data 待解密数据
     * @param key 密钥
     */
    public static byte[] decryptWithPrivateKey(byte[] data, byte[] key)
            throws Exception {
        Cipher cp = Cipher.getInstance(ECB_PADDING);
        cp.init(Cipher.DECRYPT_MODE, getPrivateKey(key));
        byte[] arr = cp.doFinal(data);
        return arr;
    }

    public static PublicKey getPublicKey(byte[] key) throws Exception{
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePublic(keySpec);
    }

    public static PrivateKey getPrivateKey(byte[] key) throws Exception{
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return  keyFactory.generatePrivate(keySpec);
    }

    /**
     * 分块加密
     *
     * @param data
     * @param key
     * */
    public static byte[] encryptWithPublicKeyBlock(byte[] data, byte[] key) throws Exception{
        int blockCount = (data.length / ENCRYPT_BLOCK);

        if ((data.length % ENCRYPT_BLOCK) != 0) {
            blockCount += 1;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream(blockCount * ENCRYPT_BLOCK);
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(key));

        for (int offset = 0; offset < data.length; offset += ENCRYPT_BLOCK) {
            int inputLen = (data.length - offset);
            if (inputLen > ENCRYPT_BLOCK) {
                inputLen = ENCRYPT_BLOCK;
            }
            byte[] encryptedBlock = cipher.doFinal(data, offset, inputLen);
            bos.write(encryptedBlock);
        }

        bos.close();
        return bos.toByteArray();
    }

    /**
     * 分块加密
     *
     * @param data
     * @param key
     * */
    public static byte[] encryptWithPrivateKeyBlock(byte[] data, byte[] key) throws Exception{
        int blockCount = (data.length / ENCRYPT_BLOCK);

        if ((data.length % ENCRYPT_BLOCK) != 0) {
            blockCount += 1;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream(blockCount * ENCRYPT_BLOCK);
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, getPrivateKey(key));

        for (int offset = 0; offset < data.length; offset += ENCRYPT_BLOCK) {
            int inputLen = (data.length - offset);
            if (inputLen > ENCRYPT_BLOCK) {
                inputLen = ENCRYPT_BLOCK;
            }
            byte[] encryptedBlock = cipher.doFinal(data, offset, inputLen);
            bos.write(encryptedBlock);
        }

        bos.close();
        return bos.toByteArray();
    }

    /**
     * 分块解密
     *
     * @param data
     * @param key
     * */
    public static byte[] decryptWithPublicKeyBlock(byte[] data, byte[] key) throws Exception{
        int blockCount = (data.length / DECRYPT_BLOCK);
        if ((data.length % DECRYPT_BLOCK) != 0) {
            blockCount += 1;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream(blockCount * DECRYPT_BLOCK);
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, getPublicKey(key));
        for (int offset = 0; offset < data.length; offset += DECRYPT_BLOCK) {
            int inputLen = (data.length - offset);
            if (inputLen > DECRYPT_BLOCK) {
                inputLen = DECRYPT_BLOCK;
            }
            byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);
            bos.write(decryptedBlock);
        }

        bos.close();
        return bos.toByteArray();
    }

    /**
     * 分块解密
     *
     * @param data
     * @param key
     * */
    public static byte[] decryptWithPrivateKeyBlock(byte[] data, byte[] key) throws Exception{
        int blockCount = (data.length / DECRYPT_BLOCK);
        if ((data.length % DECRYPT_BLOCK) != 0) {
            blockCount += 1;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream(blockCount * DECRYPT_BLOCK);
        Cipher cipher = Cipher.getInstance(ECB_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(key));
        for (int offset = 0; offset < data.length; offset += DECRYPT_BLOCK) {
            int inputLen = (data.length - offset);

            if (inputLen > DECRYPT_BLOCK) {
                inputLen = DECRYPT_BLOCK;
            }

            byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);
            bos.write(decryptedBlock);
        }

        bos.close();
        return bos.toByteArray();
    }
}
