package org.bikesim.entities;
import org.junit.jupiter.api.Test;

import static org.bikesim.enums.Direction.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {
    @Test
    void setValidPlace_shouldBeEast() {
        Bike bike = new Bike();
        bike.place(1, 5, EAST);
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void setValidPlace_shouldBe51() {
        Bike bike = new Bike();
        bike.place(5, 1, WEST);
        assertArrayEquals(new int[] {5,1}, bike.getPos());
    }

    @Test
    void setValidPlaceTwice_shouldBeWest() {
        Bike bike = new Bike();
        bike.place(1, 5, EAST);
        bike.place(5, 1, WEST);
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void setValidPlaceTwice_shouldBe15() {
        Bike bike = new Bike();
        bike.place(5, 1, WEST);
        bike.place(1, 5, EAST);
        assertArrayEquals(new int[] {1,5}, bike.getPos());
    }

    @Test
    void turnRightOnce_shouldBeEast() {
        Bike bike = new Bike();
        bike.place(3, 10, NORTH);
        bike.turnRight();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeSouth() {
        Bike bike = new Bike();
        bike.place(3, 10, EAST);
        bike.turnRight();
        assertEquals(SOUTH, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeWest() {
        Bike bike = new Bike();
        bike.place(3, 10, SOUTH);
        bike.turnRight();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeNorth() {
        Bike bike = new Bike();
        bike.place(3, 10, WEST);
        bike.turnRight();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeEast() {
        Bike bike = new Bike();
        bike.place(3, 10, SOUTH);
        bike.turnLeft();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeSouth() {
        Bike bike = new Bike();
        bike.place(3, 10, WEST);
        bike.turnLeft();
        assertEquals(SOUTH, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeWest() {
        Bike bike = new Bike();
        bike.place(3, 10, NORTH);
        bike.turnLeft();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeNorth() {
        Bike bike = new Bike();
        bike.place(3, 10, EAST);
        bike.turnLeft();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnLeftTwice_shouldBeNorth() {
        Bike bike = new Bike();
        bike.place(3, 10, SOUTH);
        bike.turnLeft();
        bike.turnLeft();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnRightTwice_shouldBeWest() {
        Bike bike = new Bike();
        bike.place(4, 9, EAST);
        bike.turnRight();
        bike.turnRight();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnRightTwice_shouldBeEast() {
        Bike bike = new Bike();
        bike.place(3, 1, EAST);
        bike.turnLeft();
        bike.turnRight();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void moveForwardOnce_shouldBe61(){
        Bike bike = new Bike();
        bike.place(5, 1, EAST);
        bike.forward();
        assertArrayEquals(new int[] {6,1}, bike.getPos());
    }

    @Test
    void moveForwardLeftForward_shouldBe33(){
        Bike bike = new Bike();
        bike.place(2, 2, SOUTH);
        bike.forward();
        bike.turnLeft();
        bike.forward();
        assertArrayEquals(new int[] {3,3}, bike.getPos());
    }

    @Test
    void getNextPos_shouldBe51() {
        Bike bike = new Bike();
        bike.place(5, 1, WEST);
        assertArrayEquals(new int[] {4,1}, bike.getNextPos());
    }

}
