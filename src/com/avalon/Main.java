package com.avalon;

import com.avalon.crypto.CRC32;
import com.avalon.utils.Log;

public class Main {

    public static void main(String[] args) {

        System.out.println(Log.hexDump(CRC32.calculate("Lorem IPSUM...".getBytes())));
    }
}
