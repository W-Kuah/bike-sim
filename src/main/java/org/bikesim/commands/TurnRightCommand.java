package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for turning right.
/**
 * Implements the command pattern to tell the simulator to turn the vehicle right.
 */
public class TurnRightCommand implements Command {
    /**
     * <p>The method that tells the simulator to turn the vehicle right</p>
     * @param simulator a simulator object that commands control
     */
    @Override
    public void execute(Simulator simulator) {
        simulator.turnVehicleRight();
    }
}
