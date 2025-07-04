package org.bikesim.entities;

import org.bikesim.enums.Direction;

// Entity for bike, containing state and behavior
public class Bike {
    private int x;
    private int y;
    private Direction direction;

    public int[] getPos() {
        return new int[] {x,y};
    }

    public void move() {
        switch (direction) {
            case NORTH:
                y--;
                break;

            case SOUTH:
                y++;
                break;

            case EAST:
                x++;
                break;

            case WEST:
                x--;
                break;
        }
    }

}
