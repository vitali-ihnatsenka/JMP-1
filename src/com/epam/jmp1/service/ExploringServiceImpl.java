package com.epam.jmp1.service;

import com.epam.jmp1.domain.Coordinate;
import com.epam.jmp1.domain.ExploreResponse;
import com.epam.jmp1.domain.Plateau;
import com.epam.jmp1.domain.Rover;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali on 10.07.2016.
 */
public class ExploringServiceImpl implements ExploringService {
    private Rover rover;
    private Plateau plateau;

    public ExploringServiceImpl() {
    }

    public ExploringServiceImpl(Rover rover, Plateau plateau) {
        this.rover = rover;
        this.plateau = plateau;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public ExploreResponse exploreRequest(Coordinate goTo) {
        if(rover.getPosition().equals(goTo)){
            return getEmptyResponse("Rover already here");
        }
        if(goTo.getX() > plateau.getMaxPoint().getX() || goTo.getY() > plateau.getMaxPoint().getY()){
            return getEmptyResponse("Incorrect point");
        }
        List<Coordinate> steps = new ArrayList<Coordinate>();
        boolean success = false;
        rover.setDestination(goTo);
        do{
            steps.add(rover.step());
        }while(rover.getState() != Rover.State.WAITING);
        if(rover.getPosition().equals(plateau.getScrap())){
            success = true;
        }
        return new ExploreResponse(steps, success, String.format("Rover arrived to point %d %d", goTo.getX(), goTo.getY()));
    }

    private ExploreResponse getEmptyResponse(String message){
        return new ExploreResponse(new ArrayList<Coordinate>(), false, message);
    }
}
