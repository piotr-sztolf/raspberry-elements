/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.core;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com) created: 2017-05-07 16:10:11
 */
public class BitwiseUtils {
    
    public static String lpad(String s, int size) {
        while(s.length() < size) {
            s = "0" + s;
        }
        return s;
    }

    public static int createMask(int lsb, int msb) {
        return ((1 << (msb - lsb + 1)) - 1) << lsb;
    }
    
    public static short[] asShorts(byte[] source, int sourceOffset, int resultSize, boolean lsbFirst) {
        short[] result = new short[resultSize];
        int lsbOffset = lsbFirst ? 0 : 1;
        int msbOffset = lsbFirst ? 1 : 0;
        for(int i = 0; i < resultSize; i += 2) {
            result[i] = (short) ((((source[i + msbOffset]) & 0xFF) << 8) | ((source[i + lsbOffset] & 0xFF)));
        }
        return result;
    }
    
    public int applyBitwiseValue(int sourceValue, int value, int lsb, int msb) {
        int mask = createMask(lsb, msb);
        return (sourceValue & (~mask)) | ((value << lsb) & mask);
    }
    
    public int getBitwiseValue(int sourceValue, int lsb, int msb) {
        return (sourceValue & ~createMask(lsb, msb)) >> lsb;
    }

    public static void main(String args[]) {
        for (int size = 0; size < 8; size++) {
            System.out.printf("--- Sise: %d ---\n", size + 1);
            for (int offset = 0; offset + size < 8; offset++) {
                int lsb = offset;
                int msb = Math.min(lsb + size, 7);
                System.out.printf("lsb: %d; msb: %d; mask: %d [%s]\n", lsb, msb, createMask(lsb, msb), lpad(Integer.toString(createMask(lsb, msb), 2), 8));
            }
        }
    }
}

