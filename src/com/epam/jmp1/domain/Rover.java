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
        int nextX = destination.getX();
        int nextY = destination.getY();
        if(destination.getX() > position.getX()){
            nextX = position.getX() + 1;
        }else if(destination.getX() < position.getX()){
            nextX = position.getX() - 1;
        }
        if(destination.getY() > position.getY()){
            nextY = position.getY() + 1;
        }else if(destination.getY() < position.getY()){
            nextY = position.getY() - 1;
        }
        Coordinate nextPosition = new Coordinate(nextX, nextY);
        if(nextPosition.equals(destination)){
            state = State.WAITING;
        }
        position = new Coordinate(nextX, nextY);
        return nextPosition;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", destination=" + destination +
                ", state=" + state +
                '}';
    }

    public static enum State{
        WAITING, GOING
    }
}
