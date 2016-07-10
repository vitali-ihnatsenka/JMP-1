package com.epam.jmp1.domain;

import com.epam.jmp1.util.CoordinateUtil;

/**
 * Created by Vitali on 09.07.2016.
 */
public class Plateau {
    private static final int DEFAULT_MAX_X = 10;
    private static final int DEFAULT_MAX_Y = 10;
    private Coordinate scrap;
    private Coordinate maxPoint;

    public Plateau() {
        maxPoint = new Coordinate(DEFAULT_MAX_X, DEFAULT_MAX_Y);
        scrap = CoordinateUtil.getRandomPoint(DEFAULT_MAX_X, DEFAULT_MAX_Y);
    }

    public Plateau(Coordinate scrap, Coordinate maxPoint) {
        this.scrap = scrap;
        this.maxPoint = maxPoint;
    }

    public Coordinate getScrap() {
        return scrap;
    }

    public Coordinate getMaxPoint() {
        return maxPoint;
    }
}
