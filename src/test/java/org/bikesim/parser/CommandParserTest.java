package org.bikesim.parser;

import org.bikesim.commands.*;
import org.bikesim.enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {
    private final CommandParser parser = new CommandParser();

    @Test
    void placeValidInput_valid() {
        Command cmd = parser.parse("PLACE 1,2,EAST");
        assertInstanceOf(PlaceCommand.class, cmd);
        PlaceCommand placeCmd = (PlaceCommand) cmd;
        assertEquals(1, placeCmd.getX());
        assertEquals(2, placeCmd.getY());
        assertEquals(Direction.EAST, placeCmd.getDir());
    }

    @Test
    void placeCaseInsensitive_valid() {
        Command cmd = parser.parse("place 3,4,west");
        assertInstanceOf(PlaceCommand.class, cmd);
    }

    @Test
    void placeInvalidCoordinates_invalid() {
        assertNull(parser.parse("PLACE a,b,NORTH"));
        assertNull(parser.parse("PLACE 1.5,2,SOUTH"));
    }

    @Test
    void placeInvalidDirection_invalid() {
        assertNull(parser.parse("PLACE 1,2,INVALID"));
    }

    @Test
    void placeMissingArguments_invalid() {
        assertNull(parser.parse("PLACE 1,2"));
        assertNull(parser.parse("PLACE 1"));
        assertNull(parser.parse("PLACE"));
    }

    @Test
    void forward_valid() {
        Command cmd = parser.parse("FORWARD");
        assertInstanceOf(ForwardCommand.class, cmd);
    }

    @Test
    void turnLeft_valid() {
        Command cmd = parser.parse("TURN_LEFT");
        assertInstanceOf(TurnLeftCommand.class, cmd);
    }

    @Test
    void turnRight_valid() {
        Command cmd = parser.parse("TURN_RIGHT");
        assertInstanceOf(TurnRightCommand.class, cmd);
    }

    @Test
    void report_valid() {
        Command cmd = parser.parse("GPS_REPORT");
        assertInstanceOf(ReportCommand.class, cmd);
    }

    @Test
    void unknownCommand_invalid() {
        assertNull(parser.parse("JUMP"));
        assertNull(parser.parse(""));
//        assertNull(parser.parse(null));
    }

    @Test
    void placeValidWhitespace_valid() {
        Command cmd = parser.parse("  PLACE  1 , 2 , EAST  ");
        assertInstanceOf(PlaceCommand.class, cmd);
    }
}
