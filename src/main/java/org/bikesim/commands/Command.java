package org.bikesim.commands;

import org.bikesim.simulator.Simulator;

// Command pattern basis

/**
 * Command pattern basis
 */
public interface Command {
    /**
     * <p>The contract method that will be use to interact with the simulator</p>
     * @param simulator a simulator object that commands control
     */
    void execute(Simulator simulator);
}
