/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.core;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com) created: 2017-05-07 18:05:34
 */
public class BitwiseValue {

    int mask;
    int lsb;
    int value;

    public BitwiseValue(int value, int lsb, int msb) {
        this.value = value;
        this.lsb = lsb;
        this.mask = ((1 << (msb - lsb + 1)) - 1) << lsb;
    }

    public BitwiseValue(int lsb, int msb) {
        this(0, lsb, msb);
    }

    public BitwiseValue apply(int value) {
        this.value = (value & (~mask)) | ((value << lsb) & mask);
        return this;
    }
    
    public BitwiseValue apply(BitwiseValue source) {
        return this;
    }

    public void clear() {
        this.value = 0;
    }

    public int get() {
        return (value & mask) >> lsb;
    }
    
    public void set(int value) {
        this.value = value;
    }

}
