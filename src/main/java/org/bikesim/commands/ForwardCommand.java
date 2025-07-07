package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for moving forward.

/**
 * Implements the command pattern to tell the simulator to move the vehicle forward.
 */
public class ForwardCommand implements Command {
    /**
     * <p>The method that tells the simulator to move the vehicle forward</p>
     * @param simulator a simulator object that commands control
     */
    @Override
    public void execute(Simulator simulator) {
        simulator.moveVehicleForward();
    }
}
