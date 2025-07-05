package org.bikesim.simulator;

import org.bikesim.entities.Bike;
import org.bikesim.entities.Grid;
import org.bikesim.enums.Direction;

// Executes commands and interfaces between bike state and grid state.
public class Simulator {
    private final Grid grid = new Grid(7, 7);
    private final Bike vehicle = new Bike();
    private boolean isVehiclePlaced = false;


    // Command Methods;
    public void placeVehicle(int x, int y, Direction direction) {
        if (grid.isValidPos(x, y)) {
            vehicle.place(x, y, direction);
            isVehiclePlaced = true;
        }
    }

    public void moveVehicleForward() {
        if (!isVehiclePlaced) return;
        int[] newPos = vehicle.getNextPos();
        if (grid.isValidPos(newPos[0], newPos[1])) {
            vehicle.forward();
        }
    }

    public void turnVehicleLeft() {
        if (isVehiclePlaced) vehicle.turnLeft();
    }

    public void turnVehicleRight() {
        if (isVehiclePlaced) vehicle.turnRight();
    }

    public void vehicleReport() {
        if (!isVehiclePlaced) return;

        int[] pos = vehicle.getPos();
        Direction facing = vehicle.getDir();
        String formattedStr = String.format("(%d, %d), %s", pos[0], pos[1], facing.name());
        System.out.println(formattedStr);
    }
}
