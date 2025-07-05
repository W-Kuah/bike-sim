package org.bikesim.enums;

import org.junit.jupiter.api.Test;

import static org.bikesim.enums.Direction.SOUTH;
import static org.junit.jupiter.api.Assertions.*;


public class DirectionTest {

    @Test
    void testDirectionValid_shouldBeValid(){
        assertNotNull(Direction.EAST);
    }

    @Test
    void testRight_shouldBeSouth() {
        assertEquals(Direction.EAST.right(), SOUTH);
    }

    @Test
    void testLeft_shouldBeSouth() {
        assertEquals(Direction.WEST.left(), SOUTH);
    }

}
