package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for reporting.
/**
 * Implements the command pattern to tell the simulator to report the vehicle's position.
 */
public class ReportCommand implements Command {
    /**
     * <p>The method that tells the simulator to report the vehicle's position</p>
     * @param simulator a simulator object that commands control
     */
    @Override
    public void execute(Simulator simulator) {
        simulator.vehicleReport();
    }
}
