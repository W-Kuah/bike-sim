package org.bikesim.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputCaptor));
    }


    @Test
    void testHeight_shouldBe9() {
        Grid grid = new Grid(3,9);
        assertEquals(grid.getHeight(), 9);
    }

    @Test
    void testWidth_shouldBe9() {
        Grid grid = new Grid(1,4);
        assertEquals(grid.getWidth(), 1);
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
