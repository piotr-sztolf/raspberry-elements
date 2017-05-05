/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sztolf.raspberry.tests;

import com.sztolf.raspberry.core.MotorRotation;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com)
 * created: 2017-05-05 07:04:12
 */
public class DirectionTest {

    public static void main(String[] args) {
        for(MotorRotation dir: MotorRotation.values()) {
            System.out.printf("%s: opposite = %s\n", dir.toString(), dir.getOpposite().toString());
        }
    }
}
