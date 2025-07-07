package org.bikesim.entities;

import org.bikesim.enums.Direction;

// Entity for bike, containing the bike's state and behavior

/**
 * Entity for bike, containing state and behavior
 */
public class Bike {
    /**
     * The x coordinate (or horizontal position) of the bike object.
     */
    private int x;
    /**
     * The y coordinate (or vertical position) of the bike object.
     */
    private int y;
    /**
     * The direction the bike object is facing.
     */
    private Direction facing;

    // Helper method

    /**
     * <p>Helper function that takes old coordinates as arguments and uses the direction state to determine new location</p>
     * @param oldX the old x (or horizontal location) coordinate
     * @param oldY the old y (or vertical coordinate) coordinate
     * @return int array that shows the new x and y coordinates
     */
    private int[] showNextPos(int oldX, int oldY){
        int newX = oldX;
        int newY = oldY;
        switch (facing) {
            case NORTH:
                newY++;
                break;

            case SOUTH:
                newY--;
                break;

            case EAST:
                newX++;
                break;

            case WEST:
                newX--;
                break;
        }
        return new int[] {newX, newY};
    }

    // Setter methods

    /**
     * <p>Can be use to create and replace the object's x and y coordinates, and directions state </p>
     * @param x the x (or horizontal location) coordinate
     * @param y the y (or vertical coordinate) coordinate
     * @param facing the direction of where the object is facing (NORTH, EAST, SOUTH, WEST)
     */
     public void place(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    /**
     * <p>Uses the showNextPos() method to move the position forward based on current coordinates and direction creating new x y states</p>
     */
    public void forward() {
        int[] newXY = showNextPos(x,y);
        this.x = newXY[0];
        this.y = newXY[1];
    }

    /**
     * <p>Invokes the direction enum's .left() to determine new facing direction state</p>
     */
    public void turnLeft() {
        this.facing = facing.left();
    }

    /**
     * <p>Invokes the direction enum's .right() to determine new facing direction state</p>
     */
    public void turnRight() {
        this.facing = facing.right();
    }

    // Getter methods

    /**
     * <p>Retrieves the direction of the bike object</p>
     * @return the direction (enum) of object
     */
    public Direction getDir() {
        return facing;
    }

    /**
     * <p>Retrieves the x y coordinates of the bike object</p>
     * @return the x y coordinates in int array form
     */
    public int[] getPos() {
        return new int[] {x,y};
    }

    /**
     * <p>Retrieves the x y coordinates of the bike object if it moves forward by invoking the showNextPos helper function</p>
     * @return the new x y coordinates in int array form
     */
    public int[] getNextPos() {
        return showNextPos(x,y);
    }

}
