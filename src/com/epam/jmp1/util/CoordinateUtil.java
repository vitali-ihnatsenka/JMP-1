package com.epam.jmp1.util;

import com.epam.jmp1.domain.Coordinate;

import java.util.Random;

/**
 * Created by Vitali on 10.07.2016.
 */
public class CoordinateUtil {
    public static Coordinate getRandomPoint(int maxX, int maxY){
        Coordinate randomCoordinate = new Coordinate();
        Random random = new Random();
        randomCoordinate.setX(random.nextInt(maxX - 1));
        randomCoordinate.setY(random.nextInt(maxY - 1));
        return  randomCoordinate;
    }
}
