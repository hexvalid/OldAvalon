package com.avalon.utils;

public class Log {

    final private static int OFFSET = 0;
    final private static int WIDTH = 16;
    final private static char SPACE = ' ';
    final private static char DOT = '.';
    final private static char SEPARATOR = '|';
    final private static char NEWLINE = '\n';

    public static String hexDump(byte[] array) {
        StringBuilder builder = new StringBuilder();
        for (int rowOffset = OFFSET; rowOffset < OFFSET + array.length; rowOffset += WIDTH) {
            builder.append(String.format("%08x  ", rowOffset));
            for (int index = 0; index < WIDTH; index++) {
                if (rowOffset + index < array.length) {
                    builder.append(String.format("%02x", array[rowOffset + index]));
                } else {
                    builder.append(SPACE);
                    builder.append(SPACE);
                }
                if (index == 7) {
                    builder.append(SPACE);
                }
                builder.append(SPACE);
            }
            int asciiWidth = Math.min(WIDTH, array.length - rowOffset);
            builder.append(SPACE);
            builder.append(SEPARATOR);
            for (int i = rowOffset; i < rowOffset + asciiWidth; i++) {
                if (array[i] < 32 || array[i] > 126) {
                    builder.append(DOT);
                } else {
                    builder.append((char) array[i]);
                }
            }
            builder.append(SEPARATOR);
            builder.append(NEWLINE);
        }
        return builder.toString();
    }
}
