package com.travel.command;

import com.travel.model.passenger.Passenger;
import com.travel.observer.SystemModel;
import com.travel.manager.PassengerManager;

public class AddPassengerCommand implements Command {
    private final Passenger p;
    public AddPassengerCommand(Passenger p) { this.p = p; }

    @Override public void execute() {
        SystemModel.getInstance().addPassenger(p);
    }

    @Override public void undo() {
        PassengerManager.getInstance().delete(p);
        SystemModel.getInstance().notifyObservers();
    }
}