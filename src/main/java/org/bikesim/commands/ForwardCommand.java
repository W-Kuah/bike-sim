package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command logic for moving forward.
public class ForwardCommand implements Command {
    @Override
    public void execute(Simulator simulator) {
        simulator.moveVehicleForward();
    }
}
