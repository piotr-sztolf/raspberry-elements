/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.core;

import com.pi4j.io.i2c.I2CDevice;
import java.io.IOException;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com) created: 2017-05-07 20:05:29
 */
public class I2CAccessor {

    public class BitwiseMapping {

        public static final int BYTE_MASK = 0xFF;

        private final int lsb;
        private final int mask;
        private final int reverseMask;

        public BitwiseMapping(int lsb, int msb) {
            this.lsb = lsb;
            this.mask = (((1 << (msb - lsb + 1)) - 1) << lsb) & BYTE_MASK;
            this.reverseMask = (~this.mask) & BYTE_MASK;
        }

        /**
         * @return the lsb
         */
        public int getLsb() {
            return lsb;
        }

        /**
         * @return the mask
         */
        public int getMask() {
            return mask;
        }

        /**
         * @return the reverseMask
         */
        public int getReverseMask() {
            return reverseMask;
        }

    }

    public class BitwiseParamDescriptor extends BitwiseMapping {

        private final int address;

        public BitwiseParamDescriptor(int address, int lsb, int msb) {
            super(lsb, msb);
            this.address = address;
        }

        /**
         * @return the address
         */
        public int getAddress() {
            return address;
        }

    }

    private final I2CDevice device;
    private int address;

    public I2CAccessor(I2CDevice device) {
        this.device = device;
    }

    public I2CAccessor withAddress(int address) {
        this.address = address;
        return this;
    }

    public I2CAccessor setBits(BitwiseMapping mapping, int value) throws IOException {
        int sourceValue = device.read(address);
        device.write(address, (byte) ((sourceValue & mapping.getReverseMask()) | ((value << mapping.getLsb()) & mapping.getMask())));
        return this;
    }
    
    public I2CAccessor setBits(BitwiseParamDescriptor descriptor, int value) {
        return withAddress(descriptor.getAddress()).setBits(descriptor, value);
    }
 

    public I2CAccessor setBits(int lsb, int msb, int value) throws IOException {
        return setBits(new BitwiseMapping(lsb, msb), value);
    }

    public I2CAccessor clearBits(BitwiseMapping mapping) throws IOException {
        return setBits(mapping, 0);
    }
    
    public I2CAccessor clearBits(BitwiseParamDescriptor descriptor) {
        return withAddress(descriptor.getAddress()).clearBits(descriptor);
    }

    public I2CAccessor clearBits(int lsb, int msb) throws IOException {
        return clearBits(new BitwiseMapping(lsb, msb));
    }

    public I2CAccessor setValue(int value) throws IOException {
        return setBits(0, 7, value);
    }

    public int getBits(BitwiseMapping mapping) throws IOException {
        return (device.read(address) & mapping.getReverseMask()) >> mapping.getLsb();
    }

    public int getBits(int lsb, int msb) throws IOException {
        return getBits(new BitwiseMapping(lsb, msb));
    }

    public int getValue() throws IOException {
        return getBits(0, 7);
    }

    public int getAddress() {
        return address;
    }

}
