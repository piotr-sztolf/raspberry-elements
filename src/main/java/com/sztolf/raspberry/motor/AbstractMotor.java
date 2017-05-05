/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.motor;

import com.google.common.collect.Maps;
import com.sztolf.raspberry.core.MotorRotation;
import java.util.Map;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com) created: 2017-05-05 07:50:16
 */
public class AbstractMotor {

    int speed = 0;
    MotorRotation rotation = MotorRotation.NONE;
    MotorController controller;
    Map<MotorRotation, Integer> minSpeedMap = Maps.newHashMap();
    Map<MotorRotation, Double> minSpeedFactorMap = Maps.newHashMap();

    public AbstractMotor(MotorController controller) {
        this.controller = controller;
        this.minSpeedMap.put(MotorRotation.LEFT, 0);
        this.minSpeedMap.put(MotorRotation.RIGHT, 0);
        this.minSpeedFactorMap.put(MotorRotation.LEFT, 1D);
        this.minSpeedFactorMap.put(MotorRotation.RIGHT, 1D);
    }

    int getEffectiveSpeed(MotorRotation rotation, int speed) {
        return (int) (minSpeedMap.get(rotation) + speed * minSpeedFactorMap.get(rotation));
    }

    int getEffectiveSpeed(int speed) {
        return getEffectiveSpeed(rotation, speed);
    }

    public void setMinSpeed(MotorRotation rotation, int minSpeed) {
        this.minSpeedMap.put(rotation, minSpeed);
        this.minSpeedFactorMap.put(rotation, (double) (controller.getMaxSpeed() - minSpeed) / (double) controller.getMaxSpeed());
    }
}
