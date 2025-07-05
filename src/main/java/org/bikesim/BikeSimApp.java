package org.bikesim;

import org.bikesim.commands.Command;
import org.bikesim.parser.CommandParser;
import org.bikesim.simulator.Simulator;

import java.io.*;

// Detects and handles input source and feeds input lines into CommandProcesor.
public class BikeSimApp {
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