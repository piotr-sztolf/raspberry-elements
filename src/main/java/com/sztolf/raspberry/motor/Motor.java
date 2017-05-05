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
public interface Motor {
    
    void setSpeed(int speed);
    
    void setRotation(MotorRotation rotation);
    
    void reverse();
    
    void stop();
    
    int getSpeed();
    
    MotorRotation getRotation();
}
