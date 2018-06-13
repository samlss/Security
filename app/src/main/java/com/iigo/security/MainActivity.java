package com.iigo.security;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;

import java.security.KeyPair;
import java.security.Provider;
import java.security.Security;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Provider[] providers = Security.getProviders();
        for (Provider provider : providers){
            System.out.println("provider: "+provider.getInfo());
        }
    }

    public void testRSA(View view){
        byte[] data = "一二三四五Hello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA Hello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSAHello RSA".getBytes();
        byte[] base64Data = Base64.encode(data, Base64.DEFAULT);

        System.err.println("原始数据长度： "+base64Data.length);

        KeyPair keyPair = RSA.generateKeyPair(2048);

        byte[] publicKeyBase64Data  = Base64.encode(keyPair.getPublic().getEncoded(), Base64.DEFAULT);
        byte[] privateKeyBase64Data = Base64.encode(keyPair.getPrivate().getEncoded(), Base64.DEFAULT);

        try {
            long start = System.currentTimeMillis();
            byte[] encryptData = RSA.encryptWithPublicKeyBlock(base64Data, Base64.decode(publicKeyBase64Data, Base64.DEFAULT));
            System.err.println("公钥加密耗时: "+(System.currentTimeMillis() - start));
            System.err.println("公钥加密后长度: "+encryptData.length);

            start = System.currentTimeMillis();
            byte[] decryptData = RSA.decryptWithPrivateKeyBlock(encryptData, Base64.decode(privateKeyBase64Data, Base64.DEFAULT));
            System.err.println("私钥解密耗时: "+(System.currentTimeMillis() - start));

            System.err.println("私钥解密后长度: "+decryptData.length);
            System.err.println("私钥数据还原为：" + new String(Base64.decode(decryptData, Base64.DEFAULT)));

            System.err.println("==========================================================");

            encryptData = RSA.encryptWithPrivateKeyBlock(base64Data, Base64.decode(privateKeyBase64Data, Base64.DEFAULT));
            System.err.println("私钥加密耗时: "+(System.currentTimeMillis() - start));
            System.err.println("私钥加密后长度: "+encryptData.length);

            start = System.currentTimeMillis();
            decryptData = RSA.decryptWithPublicKeyBlock(encryptData, Base64.decode(publicKeyBase64Data, Base64.DEFAULT));
            System.err.println("公钥解密耗时: "+(System.currentTimeMillis() - start));

            System.err.println("公钥解密后长度: "+decryptData.length);
            System.err.println("公钥数据还原为：" + new String(Base64.decode(decryptData, Base64.DEFAULT)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDES(View view){
        try{
            byte[] key = DES.generateKey();
            String base64Key = Base64.encodeToString(key, Base64.DEFAULT);
            System.out.println("key base64: "+base64Key);
            String data = "一二三四五HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld ";

            byte[] encryptData = DES.encrypt(data.getBytes(),  Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("encrypt data base64: " + Base64.encodeToString(encryptData, Base64.DEFAULT));

            byte[] decryptData = DES.decrypt(encryptData,  Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("decrypt data: " + new String(decryptData));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testDES3(View view){
        try{
            byte[] key = DES3.generateKey();
            String base64Key = Base64.encodeToString(key, Base64.DEFAULT);
            System.out.println("key base64: "+base64Key);

            String data = "一二三四五HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld ";

            byte[] encryptData = DES3.encrypt(data.getBytes(), Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("encrypt data base64: " + Base64.encodeToString(encryptData, Base64.DEFAULT));

            byte[] decryptData = DES3.decrypt(encryptData, Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("decrypt data: " + new String(decryptData));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testSHA(View view){
        try{
            String data = "一二三四五HelloWorld";

            System.out.println("SHA1 encrypt: "   + SHA.encrypt1(data));
            System.out.println("SHA224 encrypt: " + SHA.encrypt224(data));
            System.out.println("SHA256 encrypt: " + SHA.encrypt256(data));
            System.out.println("SHA384 encrypt: " + SHA.encrypt384(data));
            System.out.println("SHA512 encrypt: " + SHA.encrypt512(data));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testAES(View view){
        try{
            final byte[] key = AES.generateKey();
            String base64Key = Base64.encodeToString(key, Base64.DEFAULT);
            System.out.println("key base64: "+base64Key);
            String data = "一二三四五HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld ";

            byte[] encryptData = AES.encrypt(data.getBytes(),  Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("encrypt data base64: " + Base64.encodeToString(encryptData, Base64.DEFAULT));

            byte[] decryptData = AES.decrypt(encryptData,  Base64.decode(base64Key, Base64.DEFAULT));
            System.err.println("decrypt data: " + new String(decryptData));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testXOR(View view){
        try{
            int key = 0x1001;
            String data = "一二三四五HelloWorld ";

            byte[] encryptData = XOR.execute(data.getBytes(),  key);
            System.err.println("encrypt data: " + new String(encryptData));
            System.err.println("encrypt data base64: " + Base64.encodeToString(encryptData, Base64.DEFAULT));

            byte[] decryptData = XOR.execute(encryptData,  key);
            System.err.println("decrypt data: " + new String(decryptData));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testHMAC(View view){
        try{
            String key = "123456";
            String data = "一二三四五HelloWorld";

            System.out.println("HMAC1 encrypt: "   + HMAC.encrypt1(data.getBytes(), key.getBytes()));
            System.out.println("HMAC224 encrypt: " + HMAC.encrypt224(data.getBytes(), key.getBytes()));
            System.out.println("HMAC256 encrypt: " + HMAC.encrypt256(data.getBytes(), key.getBytes()));
            System.out.println("HMAC384 encrypt: " + HMAC.encrypt384(data.getBytes(), key.getBytes()));
            System.out.println("HMAC512 encrypt: " + HMAC.encrypt512(data.getBytes(), key.getBytes()));
            System.out.println("HMACMD5 encrypt: " + HMAC.encryptMD5(data.getBytes(), key.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
