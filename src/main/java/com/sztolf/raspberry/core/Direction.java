/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sztolf.raspberry.core;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 *
 * @author Piotr Sztolf (piotr.sztolf@gmail.com)
 */
public enum Direction {

    FORWARD,
    NORTH,
    BACKWARD,
    SOUTH,
    LEFT,
    WEST,
    RIGHT,
    EAST;

    private static final Map<Direction, Direction> oppositeMap = Maps.newHashMap();
    private static final Map<Direction, Direction> synonymMap = Maps.newHashMap();

    static {
        oppositeMap.put(FORWARD, BACKWARD);
        oppositeMap.put(NORTH, SOUTH);
        oppositeMap.put(BACKWARD, FORWARD);
        oppositeMap.put(SOUTH, NORTH);
        oppositeMap.put(LEFT, RIGHT);
        oppositeMap.put(WEST, EAST);
        oppositeMap.put(RIGHT, LEFT);
        oppositeMap.put(EAST, WEST);

        synonymMap.put(FORWARD, NORTH);
        synonymMap.put(NORTH, FORWARD);
        synonymMap.put(BACKWARD, SOUTH);
        synonymMap.put(SOUTH, BACKWARD);
        synonymMap.put(LEFT, WEST);
        synonymMap.put(WEST, LEFT);
        synonymMap.put(RIGHT, EAST);
        synonymMap.put(EAST, RIGHT);
    }

    public Direction getOpposite() {
        return oppositeMap.get(this);
    }

    public Direction getSynonym() {
        return synonymMap.get(this);
    }

}
