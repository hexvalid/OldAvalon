package com.avalon;

import com.avalon.crypto.JV;
import com.avalon.utils.Log;

public class Main {

    public static void main(String[] args) {
        byte[] publicKey = {(byte) 0xa1, (byte) 0xa2, (byte) 0xa3, (byte) 0xa4, (byte) 0xa5, (byte) 0xa6, (byte) 0xa7, (byte) 0xa8};
        JV jv = new JV(publicKey);
        System.out.println(Log.hexDump(jv.encryptionFast("ALFA".getBytes())));
    }
}
