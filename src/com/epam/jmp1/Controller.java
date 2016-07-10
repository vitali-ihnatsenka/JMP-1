package com.epam.jmp1;

import com.epam.jmp1.domain.Coordinate;
import com.epam.jmp1.domain.ExploreResponse;
import com.epam.jmp1.domain.Plateau;
import com.epam.jmp1.domain.Rover;
import com.epam.jmp1.service.*;

public class Controller {

    public static void main(String[] args) {
        InputService inputService = new ConsoleInputServiceImpl();
        OutputService outputService = new ConsoleOutputServiceImpl();
        ExploringService exploringService = new ExploringServiceImpl(new Rover(), new Plateau());
        boolean end = false;
        do{
            Coordinate destinationPoint = inputService.readCoordinate();
            ExploreResponse response = exploringService.exploreRequest(destinationPoint);
            outputService.write(response);
            end = response.isSuccessful();
        }while(!end);

    }

}
