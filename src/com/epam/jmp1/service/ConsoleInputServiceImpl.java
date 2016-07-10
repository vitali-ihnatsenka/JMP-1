package com.epam.jmp1.service;

import com.epam.jmp1.domain.Coordinate;

/**
 * Created by Vitali on 10.07.2016.
 */
public class ConsoleInputServiceImpl implements InputService{

    @Override
    public Coordinate readCoordinate() {
        int inputX = getIntInput("Enter X: ");
        int inputY = getIntInput("Enter Y: ");
        return new Coordinate(inputX, inputY);
    }

    private int getIntInput(String inputMessage){
        System.out.println(inputMessage);
        try {
            return Integer.parseInt(System.console().readLine());
        }catch(NumberFormatException e){
            System.out.println("Number only.");
            return getIntInput(inputMessage);
        }
    }
}
