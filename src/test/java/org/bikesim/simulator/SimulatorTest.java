package org.bikesim.simulator;

import org.bikesim.enums.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulatorTest {
    private Simulator simulator;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        simulator = new Simulator();
        System.setOut(new PrintStream(outputCaptor));
    }

    @AfterEach
    void tearDown() {
        outputCaptor.reset();
    }

    private String getReportOutput() {
        return outputCaptor.toString().trim();
    }

    @Test
    void beforeValidPlace_ShouldIgnore() {
        simulator.turnVehicleLeft();
        simulator.moveVehicleForward();
        simulator.vehicleReport();
        assertTrue(getReportOutput().isEmpty(),
                "Should not output report before placement");
    }

    @Test
    void afterValidPlace_ShouldActivate() {
        simulator.placeVehicle(3, 3, Direction.EAST);
        simulator.vehicleReport();
        assertEquals("(3,3), EAST", getReportOutput());
    }

    @Test
    void invalidPlaceCoordinates_ShouldIgnore() {

        simulator.placeVehicle(10, 10, Direction.NORTH);  // Out of bounds
        simulator.vehicleReport();

        assertTrue(getReportOutput().isEmpty(),
                "Should not activate with invalid placement");
    }

    @Test
    void withinBoundaries_ShouldMove() {

        simulator.placeVehicle(0, 0, Direction.NORTH);


        simulator.moveVehicleForward();  // Valid move
        simulator.vehicleReport();

        assertEquals("(0,1), NORTH", getReportOutput());
    }

    @Test
    void boundaryBreach_ShouldPrevent() {

        simulator.placeVehicle(0, 0, Direction.SOUTH);


        simulator.moveVehicleForward();  // Would go to (0,-1) - invalid
        simulator.vehicleReport();

        assertEquals("(0,0), SOUTH", getReportOutput(),
                "Should stay in place on boundary breach");
    }

    @Test
    void consecutiveBoundaryHits_ShouldBe65North() {

        simulator.placeVehicle(6, 6, Direction.NORTH);


        simulator.moveVehicleForward();  // Invalid (6,7)
        simulator.turnVehicleRight();    // Face EAST
        simulator.moveVehicleForward();  // Invalid (7,6)
        simulator.turnVehicleRight();    // Face SOUTH
        simulator.moveVehicleForward();  // Valid (6,5)
        simulator.vehicleReport();

        assertEquals("(6,5), SOUTH", getReportOutput());
    }

    @Test
    void turnCommands_ShouldBe22South22North() {

        simulator.placeVehicle(2, 2, Direction.WEST);


        simulator.turnVehicleLeft();   // Should face SOUTH
        simulator.vehicleReport();
        String afterLeft = getReportOutput();
        outputCaptor.reset();

        simulator.turnVehicleRight();  // Back to WEST
        simulator.turnVehicleRight();  // Face NORTH
        simulator.vehicleReport();

        assertEquals("(2,2), SOUTH", afterLeft);
        assertEquals("(2,2), NORTH", getReportOutput());
    }

    @Test
    void stateOnReplacement_ShouldReset43South() {

        simulator.placeVehicle(1, 1, Direction.EAST);
        simulator.moveVehicleForward();  // (2,1)


        simulator.placeVehicle(4, 3, Direction.SOUTH);  // New position
        simulator.vehicleReport();

        assertEquals("(4,3), SOUTH", getReportOutput());
    }

    @Test
    void complexCommandSequence_Should33North() {
        simulator.placeVehicle(1, 2, Direction.EAST);
        simulator.moveVehicleForward();  // (2,2)
        simulator.moveVehicleForward();  // (3,2)
        simulator.turnVehicleLeft();     // NORTH
        simulator.moveVehicleForward();  // (3,3)
        simulator.vehicleReport();

        assertEquals("(3,3), NORTH", getReportOutput());
    }

//    @Test
//    void invalidPlaceDirection_ShouldIgnore() {
//
//        simulator.placeVehicle(3, 3, null);  // Invalid direction
//        simulator.vehicleReport();
//
//        assertTrue(getReportOutput().isEmpty(),
//                "Should ignore placement with invalid direction");
//    }

    @Test
    void edgeMovementNorth_Should36North() {

        simulator.placeVehicle(3, 6, Direction.NORTH);


        simulator.moveVehicleForward();  // Should be blocked
        simulator.vehicleReport();

        assertEquals("(3,6), NORTH", getReportOutput());
    }

    @Test
    void edgeMovementWest_Should03West() {

        simulator.placeVehicle(0, 3, Direction.WEST);


        simulator.moveVehicleForward();  // Should be blocked
        simulator.vehicleReport();

        assertEquals("(0,3), WEST", getReportOutput());
    }

    @Test
    void shouldHandleMultipleReplacements() {

        simulator.placeVehicle(5, 5, Direction.SOUTH);
        simulator.placeVehicle(2, 2, Direction.NORTH);  // Valid replacement
        simulator.placeVehicle(8, 8, Direction.EAST);   // Invalid
        simulator.vehicleReport();

        assertEquals("(2,2), NORTH", getReportOutput());
    }

    @Test
    void shouldNotReportWhenInactive() {

        simulator.vehicleReport();  // Before placement
        simulator.placeVehicle(0, 0, Direction.NORTH);
        simulator.vehicleReport();  // First valid report
        simulator.placeVehicle(7, 7, Direction.WEST);  // Invalid
        simulator.vehicleReport();  // Should show previous state

        String[] reports = getReportOutput().split(System.lineSeparator());
        assertEquals(2, reports.length);
        assertEquals("(0,0), NORTH", reports[0]);
    }
}
