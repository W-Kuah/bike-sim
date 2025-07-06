package org.bikesim;

import org.bikesim.simulator.Simulator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BikeSimAppTest {
    private final ByteArrayOutputStream outputCapture = new ByteArrayOutputStream();

    // Helper function

    private String getLastReportOutput() {
        String[] lines = outputCapture.toString().trim().split(System.lineSeparator());
        return lines[lines.length -1];
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputCapture));
    }
    @AfterEach
    void tearDown() {
        outputCapture.reset();
    }

    @Test
    void fileInput_valid() throws Exception {
        // Create temporary command file
        Path inputFile = Files.createTempFile("test", ".txt");
        Files.write(inputFile, Arrays.asList(
                "PLACE 1,2,EAST",
                "FORWARD",
                "TURN_LEFT",
                "GPS_REPORT"
        ));

        // Execute main with file argument
        BikeSimApp.main(new String[]{inputFile.toString()});

        assertEquals("(2,2), NORTH", getLastReportOutput() );
    }

    @Test
    void fileInput_invalid() throws Exception {
        // Create temporary command file
        Path inputFile = Files.createTempFile("test", ".txt");
        Files.write(inputFile, Arrays.asList(
                "PLACE 1,2,WEST",
                "FORWARD",
                "TURN_LEFT",
                "GPS_REPORT"
        ));

        // Execute main with file argument
        BikeSimApp.main(new String[]{inputFile.toString()});

        assertNotEquals("(2,2), NORTH", getLastReportOutput() );
    }
    @Test
    void realInput1_valid() throws Exception {

        // Execute main with file argument
        BikeSimApp.main(new String[]{"test-inputs/example1.txt"});

        assertEquals("(0,6), NORTH", getLastReportOutput() );
    }

    @Test
    void realInput2_valid() throws Exception {

        // Execute main with file argument
        BikeSimApp.main(new String[]{"test-inputs/example2.txt"});

        assertEquals("(0,0), WEST", getLastReportOutput() );
    }

    @Test
    void realInput3_valid() throws Exception {

        // Execute main with file argument
        BikeSimApp.main(new String[]{"test-inputs/example3.txt"});

        assertEquals("(3,3), NORTH", getLastReportOutput() );
    }


    @Test
    void stdinInput_valid() {
        // Simulate user input
        String input = "PLACE 0,0,NORTH\nFORWARD\nGPS_REPORT\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BikeSimApp.main(new String[]{});

        assertEquals("(0,1), NORTH", getLastReportOutput() );
    }

    @Test
    void stdinInput_invalid() {
        // Simulate user input
        String input = "PLACE 4,4,NORTH\nFORWARD\nGPS_REPORT\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BikeSimApp.main(new String[]{});

        assertNotEquals("(3,3), SOUTH", getLastReportOutput() );
    }

    @Test
    void missingFile_error() {
        System.setErr(new PrintStream(outputCapture));
        BikeSimApp.main(new String[]{"nonexistent.txt"});

        String lastLine = getLastReportOutput();
        assertTrue(lastLine.contains("Input file not found: nonexistent.txt"));
    }

    @Test
    void emptyInput_invalid() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
        BikeSimApp.main(new String[]{});

        assertEquals("", getLastReportOutput());
    }

    @Test
    void discardPrePlaceCommands_valid() {
        String input = "TURN_LEFT\nFORWARD\nPLACE 2,2,WEST\nGPS_REPORT";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BikeSimApp.main(new String[]{});

        assertEquals("(2,2), WEST", getLastReportOutput());
    }

    @Test
    void skipInvalidCommand_valid() {
        String input = "PLACE 5,5,NORTH\nJUMP\nSPIN\nGPS_REPORT";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BikeSimApp.main(new String[]{});

        assertEquals("(5,5), NORTH", getLastReportOutput());
    }





}
