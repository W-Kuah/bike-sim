package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for turning right.
public class TurnRightCommand implements Command {
    @Override
    public void execute(Simulator simulator) {
        simulator.turnVehicleRight();
    }
}
