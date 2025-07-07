package org.bikesim.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    void testHeight_shouldBe9() {
        Grid grid = new Grid(3,9);
        assertEquals(grid.height(), 9);
    }

    @Test
    void testWidth_shouldBe9() {
        Grid grid = new Grid(1,4);
        assertEquals(grid.width(), 1);
    }

    @Test
    void testIsValid_shouldBeValid() {
        Grid grid = new Grid(7,7);
        assertTrue(grid.isValidPos(2, 3));
    }

    @Test
    void testIsValid_shouldBeInValidWidth() {
        Grid grid = new Grid(7,7);
        assertFalse(grid.isValidPos(7, 3));
    }

    @Test
    void testIsValid_shouldBeInValidHeight() {
        Grid grid = new Grid(7,7);
        assertFalse(grid.isValidPos(1, 7));
    }
}
