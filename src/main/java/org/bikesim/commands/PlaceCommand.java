package org.bikesim.commands;

import org.bikesim.enums.Direction;
import org.bikesim.simulator.Simulator;

// Command logic for moving placement.
public class PlaceCommand implements Command {
    private final int x;
    private final int y;
    private final Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getter
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Direction getDir(){
        return direction;
    }
    @Override
    public void execute(Simulator simulator) {
        simulator.placeVehicle(x, y, direction);
    }
}
