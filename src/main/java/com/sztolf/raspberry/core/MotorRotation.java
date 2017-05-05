/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.core;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com)
 */
public enum MotorRotation {

    LEFT,
    RIGHT,
    NONE;

    public MotorRotation getOpposite() {
        switch(this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return NONE;
        }
    }

}
