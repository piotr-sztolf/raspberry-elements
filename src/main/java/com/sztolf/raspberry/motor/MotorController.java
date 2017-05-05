/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sztolf.raspberry.motor;

import com.sztolf.raspberry.core.MotorRotation;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com)
 */
public interface MotorController {
    
    int getMaxSpeed();

    void applyRotation(MotorRotation rotation);
    
    void applySpeed(int speed);
}
