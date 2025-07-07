package org.bikesim.entities;

// Entity for grid, containing state and boundary management.

/**
 * Grid is the entity we will be using for state size and boundary management.
 */
public class Grid {
    /**
     * The width of the grid.
     */
    private final int width;
    /**
     * The height of the grid.
     */
    private final int height;

    /**
     * <p>Constructor for the grid.</p>
     * @param width width of the grid.
     * @param height height of the grid.
     */
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Getter method

    /**
     * <p>Retrieves the width of the grid.</p>
     * @return the width of grid
     */
    public int getWidth() {
        return width;
    }

    /**
     * <p>Retrieves the height of the grid.</p>
     * @return height the height of the grid
     */
    public int getHeight() {
        return height;
    }

    /**
     * <p>Checks if the given coordinates are valid relative to the boundaries of the grid.</p>
     * @param x the x (or horizontal location) coordinate
     * @param y the y (or vertical coordinate) coordinate
     * @return a boolean value that informs whether the coordinate is valid (within bounds) or invalid (out of bounds).
     */
    public boolean isValidPos(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
