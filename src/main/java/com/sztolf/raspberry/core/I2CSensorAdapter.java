/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sztolf.raspberry.core;

import com.pi4j.io.i2c.I2CDevice;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com)
 * created: 2017-05-07 16:08:19
 */
public class I2CSensorAdapter<T> {
    
    private final I2CDevice device;

    public I2CSensorAdapter(I2CDevice device) {
        this.device = device;
    }

    /**
     * @return the device
     */
    public I2CDevice getDevice() {
        return device;
    }

    
    

}
