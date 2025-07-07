package org.bikesim.commands;

import org.bikesim.enums.Direction;
import org.bikesim.simulator.Simulator;

// Command logic for moving placement.
public class PlaceCommand implements Command {
    /**
     * The x coordinate (or horizontal position) dictated by the user.
     */
    private final int x;
    /**
     * The y coordinate (or vertical position) dictated by the user.
     */
    private final int y;
    /**
     * The direction dictated by the user.
     */
    private final Direction direction;

    /**
     * <p>The constructor for this implement, sets the x y coordinate, and the direction to be used with the placeVehicle() function in the simulator.</p>
     * @param x
     * @param y
     * @param direction
     */
    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getter

    /**
     * <p>The getter function for the x coordinate</p>
     * @return the x coordinate
     */
    public int getX(){
        return x;
    }
    /**
     * <p>The getter function for the y coordinate</p>
     * @return the y coordinate
     */
    public int getY(){
        return y;
    }
    /**
     * <p>The getter function for the direction</p>
     * @return the direction
     */
    public Direction getDir(){
        return direction;
    }
    /**
     * <p>The method that tells the simulator to place the vehicle</p>
     * @param simulator a simulator object that commands control
     */
    @Override
    public void execute(Simulator simulator) {
        simulator.placeVehicle(x, y, direction);
    }
}
