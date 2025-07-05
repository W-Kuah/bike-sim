package org.bikesim.parser;

import org.bikesim.commands.*;
import org.bikesim.enums.Direction;

// Converts text to commands
public class CommandParser {
    public Command parse(String input) {
        String normalized = input.trim().toUpperCase();

        if (normalized.startsWith("PLACE")) {
            return parsePlaceCommand(normalized);
        } else if ("FORWARD".equals(normalized)) {
            return new ForwardCommand();
        } else if ("TURN_LEFT".equals(normalized)) {
            return new TurnLeftCommand();
        } else if ("GPS_REPORT".equals(normalized)) {
            return new ReportCommand();
        }
        return null;
    }

    private Command parsePlaceCommand(String input) {
        // Remove "PLACE" prefix and trim whitespace
        String paramsString = input.substring(5).trim();

        // Split parameters by commas
        String[] parts = paramsString.split(",");

        // Validate parameter count
        if (parts.length != 3) {
            return null;  // Invalid format
        }

        try {
            // Parse coordinates
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());

            // Parse direction
            String directionStr = parts[2].trim();
            Direction direction;
            try {
                direction = Direction.valueOf(directionStr);
            } catch (IllegalArgumentException e) {
                // Invalid direction
                // Possible to print error
                return null;
            }

            // Return valid command
            return new PlaceCommand(x, y, direction);

        } catch (NumberFormatException e) {
            // Non-integer coordinates
            // Possible to print error
            return null;
        }
    }
}
