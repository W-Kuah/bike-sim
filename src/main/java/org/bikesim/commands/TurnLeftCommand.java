package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for turning left.
/**
 * Implements the command pattern to tell the simulator to turn the vehicle left.
 */
public class TurnLeftCommand implements Command {
    /**
     * <p>The method that tells the simulator to turn the vehicle left</p>
     * @param simulator a simulator object that commands control
     */
    @Override
    public void execute(Simulator simulator) {
        simulator.turnVehicleLeft();
    }
}
