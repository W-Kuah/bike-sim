package org.bikesim.entities;

// Entity for grid, containing state and boundary management.
public class Grid {
    private int width;
    private int height;

    public boolean isValidPos(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
