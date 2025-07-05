package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command pattern basis
public interface Command {
    void execute(Simulator simulator);
}
