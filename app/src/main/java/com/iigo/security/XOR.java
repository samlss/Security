package com.iigo.security;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/12 0012 17:36
 */

public class XOR {
    private XOR(){}

    public static byte[] execute(byte[] data, int key) {
        if (data == null || data.length == 0){
            return null;
        }

        int length = data.length;

        for (int i = 0; i < length; i++) {
            data[i] ^= key;
        }

        return data;
    }
}
