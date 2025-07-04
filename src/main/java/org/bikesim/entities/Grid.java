package org.bikesim.entities;

// Entity for grid, containing state and boundary management.
public class Grid {
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isValidPos(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
