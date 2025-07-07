package org.bikesim.simulator;

import org.bikesim.entities.Bike;
import org.bikesim.entities.Grid;
import org.bikesim.enums.Direction;

// Executes commands and interfaces between bike state and grid state.

/**
 * Simulator is the entity that orchestrates how the bike entity and grid entity interact
 */
public class Simulator {
    /**
     * The grid object
     */
    private final Grid grid = new Grid(7, 7);
    /**
     * The bike/vehicle object
     */
    private final Bike vehicle = new Bike();
    /**
     * The boolean value informing if a vehicle has been placed
     */
    private boolean isVehiclePlaced = false;

    // Command Methods;

    /**
     * <p>Check if provided x and y coordinates and direction are valid relative to the grid boundaries (invokes the bike's isValidPos()).
     * If true, invoke bike's place method and change simulation's state to know vehicle has been placed.
     * </p>
     * @param x the x (or horizontal location) coordinate
     * @param y the y (or vertical coordinate) coordinate
     * @param direction the facing direction (NORTH, EAST, SOUTH, WEST)
     */
    public void placeVehicle(int x, int y, Direction direction) {
        if (grid.isValidPos(x, y)) {
            vehicle.place(x, y, direction);
            isVehiclePlaced = true;
        }
    }

    /**
     * <p>Check if simulation has placed vehicle, if true, fetch new position by invoking bike's .getNextPos().
     * Invoke the bike's forward() function to move the vehicle forward, if the new position is valid.
     * </p>
     */
    public void moveVehicleForward() {
        if (!isVehiclePlaced) return;
        int[] newPos = vehicle.getNextPos();
        if (grid.isValidPos(newPos[0], newPos[1])) {
            vehicle.forward();
        }
    }

    /**
     * <p>Check if simulation has placed vehicle, if true, turn the bike left by invoking the bike's turnLeft() function</p>
     */
    public void turnVehicleLeft() {
        if (isVehiclePlaced) vehicle.turnLeft();
    }

    /**
     * <p>Check if simulation has placed bike, if true, turn the bike right by invoking the bike's turnRight() function</p>
     */
    public void turnVehicleRight() {
        if (isVehiclePlaced) vehicle.turnRight();
    }

    /**
     * <p>Check if simulation has placed bike, if true, retrieve the current X Y coordinates and directions and print in console.</p>
     */
    public void vehicleReport() {
        if (!isVehiclePlaced) return;

        int[] pos = vehicle.getPos();
        Direction facing = vehicle.getDir();
        String formattedStr = String.format("(%d,%d), %s", pos[0], pos[1], facing.name());
        System.out.println(formattedStr);
    }
}
