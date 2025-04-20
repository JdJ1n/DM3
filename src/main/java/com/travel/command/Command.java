package com.travel.command;

/**
 * Command interface for the Command pattern.
 * Each concrete command will execute an action on the TravelModel.
 */
public interface Command {
    void execute();
}

