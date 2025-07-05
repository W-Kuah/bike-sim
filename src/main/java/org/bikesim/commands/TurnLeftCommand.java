package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for turning left.
public class TurnLeftCommand implements Command {
    @Override
    public void execute(Simulator simulator) {
        simulator.turnVehicleLeft();
    }
}
