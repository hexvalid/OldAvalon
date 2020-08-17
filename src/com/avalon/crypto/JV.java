package com.avalon.crypto;

public class JV {
    private static final byte[] PRIVATE_KEY = {0x66, (byte) 0x89, 0x12, 0x20, 0x01, 0x50, 0x07, 0x12};
    private static final short R_KEY = 2157;
    private static final short R_KEY_M = 2171;

    public static byte[] xorKey(byte[] publicKey) {
        byte[] xorKey = new byte[8];
        for (int i = 0; i < 8; i++) {
            xorKey[i] = (byte) (publicKey[i] ^ PRIVATE_KEY[i]);
        }
        return xorKey;
    }

    public static byte[] encryptionFast(byte[] data, byte[] xorKey) {
        int length = data.length;
        byte[] result = new byte[length];
        int lKey, rsk;
        int rKey = R_KEY;
        lKey = (length * 157) & 0xFF;
        for (int i = 0; i < length; i++) {
            rsk = (rKey >> 8) & 0xFF;
            result[i] = (byte) (((data[i] ^ rsk) ^ (int) xorKey[(i % 8)]) ^ lKey);
            rKey *= R_KEY_M;
        }
        return result;
    }
}
