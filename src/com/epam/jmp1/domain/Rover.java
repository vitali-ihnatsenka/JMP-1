package com.epam.jmp1.domain;

/**
 * Created by Vitali on 09.07.2016.
 */
public class Rover {
    private Coordinate position;
    private Coordinate destination;
    private State state = State.WAITING;

    public Rover() {
        position = new Coordinate(0,0);
        destination = new Coordinate(0, 0);
    }

    public Rover(Coordinate position) {
        this.position = position;
        this.destination = position;
    }

    public Coordinate getPosition(){
        return position;
    }

    public State getState(){
        return state;
    }

    public void setDestination (Coordinate destination){
        if(destination.equals(position)){
            return;
        }
        state = State.GOING;
        this.destination = destination;
    }

    public Coordinate step(){
        if(destination.equals(position)){
            state = State.WAITING;
            return destination;
        }
        Coordinate nextPosition = new Coordinate(position.getX(), position.getY());
        if(destination.getX() > position.getX()){
            nextPosition.setX(position.getX() + 1);
        }else if(destination.getX() < position.getX()){
            nextPosition.setX(position.getX() - 1);
        }
        if(destination.getY() > position.getY()){
            nextPosition.setY(position.getY() + 1);
        }else if(destination.getY() < position.getY()){
            nextPosition.setX(position.getY() - 1);
        }
        if(nextPosition.equals(destination)){
            state = State.WAITING;
        }
        position = nextPosition;
        return nextPosition;
    }

    private void updateState(){}

    public static enum State{
        WAITING, GOING
    }
}
