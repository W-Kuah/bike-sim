package org.bikesim.entities;

import org.bikesim.enums.Direction;

// Entity for bike, containing state and behavior
public class Bike {
    private int x;
    private int y;
    private Direction facing;

    // Helper method
    private int[] showNextPos(int oldX, int oldY){
        int newX = oldX;
        int newY = oldY;
        switch (facing) {
            case NORTH:
                newY--;
                break;

            case SOUTH:
                newY++;
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
     public void place(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void forward() {
        int[] newXY = showNextPos(x,y);
        this.x = newXY[0];
        this.y = newXY[1];
    }

    public void turnLeft() {
        this.facing = facing.left();
    }

    public void turnRight() {
        this.facing = facing.right();
    }

    // Getter methods
    public Direction getDir() {
        return facing;
    }
    public int[] getPos() {
        return new int[] {x,y};
    }
    public int[] getNextPos() {
        return showNextPos(x,y);
    }





}
