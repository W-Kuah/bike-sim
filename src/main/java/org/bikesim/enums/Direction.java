package org.bikesim.enums;

//Provides type for direction

/**
 * Direction enum type containing 'NORTH', 'EAST', 'SOUTH', and 'WEST'
 */
public enum Direction {
    /**
     * North direction
     */
    NORTH,
    /**
     * East direction
     */
    EAST,
    /**
     * South direction
     */
    SOUTH,
    /**
     * West direction
     */
    WEST;

    /**
     * <p>Turn left</p>
     * @return different direction based on current direction
     */
    public Direction left() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    /**
     * <p>Turn Right</p>
     * @return different direction based on current direction
     */
    public Direction right() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
}
