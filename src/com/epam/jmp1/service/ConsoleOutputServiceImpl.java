package com.epam.jmp1.service;

import com.epam.jmp1.domain.Coordinate;
import com.epam.jmp1.domain.ExploreResponse;

import java.util.List;

/**
 * Created by Vitali on 10.07.2016.
 */
public class ConsoleOutputServiceImpl implements OutputService {
    @Override
    public void write(ExploreResponse response) {
        List<Coordinate> steps = response.getSteps();
        for(Coordinate coordinate: steps){
            System.out.printf("Go to (%d, %d)\n", coordinate.getX(), coordinate.getY());
        }
        System.out.println(response.getMessage());
        if(response.isSuccessful()){
            System.out.println("Mission successful!");
        }else{
            System.out.println("There is no scrap");
        }
    }
}
