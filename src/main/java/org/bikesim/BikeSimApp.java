package org.bikesim;

import org.bikesim.commands.Command;
import org.bikesim.parser.CommandParser;
import org.bikesim.simulator.Simulator;

import java.io.*;

// Detects and handles input source and feeds input lines into CommandParser which could be fed into simulator.

/**
 * The app that detects and handles input source and feeds input lines into CommandParser object which could be fed into simulator if not null.
 */
public class BikeSimApp {
    /**
     * <p>Runs when instantiated</p>
     * @param args the actual string input by the user separate by whitespace into string arrays
     */
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        CommandParser parser = new CommandParser();

        try (BufferedReader reader = createReader(args)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Command cmd = parser.parse(line);
                if (cmd != null) cmd.execute(simulator);
            }
        }  catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    /**
     * <p>Method determines what mode to run in and to handle file errors</p>
     * @param args string array input from users
     * @return a FileReader object with a valid input file or input stream reader depending on params
     * @throws IOException if argument is present and file is not found (or file cannot be read)
     */
    private static BufferedReader createReader(String[] args) throws IOException {
        if (args.length > 0) {
            // File input mode
            File inputFile = new File(args[0]);
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Input file not found: " + args[0]);
            }
            if (!inputFile.canRead()) {
                throw new IOException("Cannot read input file: " + args[0]);
            }
            return new BufferedReader(new FileReader(inputFile));
        } else {
            // STDIN mode
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }
}