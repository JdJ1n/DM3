//package com.travel.command;
//
//import com.travel.model.*;
//import com.travel.observer.*;
//
///**
// * Concrete Command to reserve a seat on a flight.
// * It creates a new itinerary for the flight if a seat is available.
// */
//public class ReserveSeatCommand implements Command {
//    private TravelModel model;
//    private Flight flight;
//
//    public ReserveSeatCommand(TravelModel model, Flight flight) {
//        this.model = model;
//        this.flight = flight;
//    }
//
//    @Override
//    public void execute() {
//        // Attempt to reserve a seat on the given flight
//        boolean success = model.addItinerary(flight);
//        if (!success) {
//            System.out.println("ReserveSeatCommand: No available seats on Flight " + flight.getId());
//        }
//    }
//}
//
