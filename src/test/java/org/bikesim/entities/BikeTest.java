package org.bikesim.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.bikesim.enums.Direction.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {
    private Bike bike;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bike = new Bike();
        System.setOut(new PrintStream(outputCaptor));
    }



    @Test
    void setValidPlace_shouldBeEast() {
        bike.place(1, 5, EAST);
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void setValidPlace_shouldBe51() {
        bike.place(5, 1, WEST);
        assertArrayEquals(new int[] {5,1}, bike.getPos());
    }

    @Test
    void setValidPlaceTwice_shouldBeWest() {
        bike.place(1, 5, EAST);
        bike.place(5, 1, WEST);
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void setValidPlaceTwice_shouldBe15() {
        bike.place(5, 1, WEST);
        bike.place(1, 5, EAST);
        assertArrayEquals(new int[] {1,5}, bike.getPos());
    }

    @Test
    void turnRightOnce_shouldBeEast() {
        bike.place(3, 10, NORTH);
        bike.turnRight();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeSouth() {
        bike.place(3, 10, EAST);
        bike.turnRight();
        assertEquals(SOUTH, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeWest() {
        bike.place(3, 10, SOUTH);
        bike.turnRight();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnRightOnce_shouldBeNorth() {
        bike.place(3, 10, WEST);
        bike.turnRight();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeEast() {
        bike.place(3, 10, SOUTH);
        bike.turnLeft();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeSouth() {
        bike.place(3, 10, WEST);
        bike.turnLeft();
        assertEquals(SOUTH, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeWest() {
        bike.place(3, 10, NORTH);
        bike.turnLeft();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnLeftOnce_shouldBeNorth() {
        bike.place(3, 10, EAST);
        bike.turnLeft();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnLeftTwice_shouldBeNorth() {
        bike.place(3, 10, SOUTH);
        bike.turnLeft();
        bike.turnLeft();
        assertEquals(NORTH, bike.getDir());
    }

    @Test
    void turnRightTwice_shouldBeWest() {
        bike.place(4, 9, EAST);
        bike.turnRight();
        bike.turnRight();
        assertEquals(WEST, bike.getDir());
    }

    @Test
    void turnRightTwice_shouldBeEast() {
        bike.place(3, 1, EAST);
        bike.turnLeft();
        bike.turnRight();
        assertEquals(EAST, bike.getDir());
    }

    @Test
    void moveForwardOnce_shouldBe61(){
        bike.place(5, 1, EAST);
        bike.forward();
        assertArrayEquals(new int[] {6,1}, bike.getPos());
    }

    @Test
    void moveForwardLeftForward_shouldBe33(){
        bike.place(2, 2, SOUTH);
        bike.forward();
        bike.turnLeft();
        bike.forward();
        assertArrayEquals(new int[] {3,1}, bike.getPos());
    }

    @Test
    void getNextPos_shouldBe51() {
        bike.place(5, 1, WEST);
        assertArrayEquals(new int[] {4,1}, bike.getNextPos());
    }

    @Test
    void getNextPos_shouldBe64() {
        bike.place(6, 4, NORTH);
        assertArrayEquals(new int[] {6,5}, bike.getNextPos());
    }

}
