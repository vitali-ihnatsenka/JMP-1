package com.epam.jmp1.domain;

import java.util.List;

/**
 * Created by Vitali on 10.07.2016.
 */
public class ExploreResponse {
    private List<Coordinate> steps;
    private boolean successful;
    private String message;

    public ExploreResponse(List<Coordinate> steps, boolean successful, String message) {
        this.steps = steps;
        this.successful = successful;
        this.message = message;
    }

    public List<Coordinate> getSteps() {
        return steps;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
