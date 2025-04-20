//package com.travel.command;
//
//import com.travel.model.*;
//import com.travel.observer.*;
///**
// * Concrete Command to create a new trip.
// * In this implementation, a "trip" is treated as a new Flight added under a selected company.
// */
//public class CreateTripCommand implements Command {
//    private TravelModel model;
//    private Company company;
//    private String origin;
//    private String destination;
//    private int totalSeats;
//
//    public CreateTripCommand(TravelModel model, Company company,
//                             String origin, String destination, int totalSeats) {
//        this.model = model;
//        this.company = company;
//        this.origin = origin;
//        this.destination = destination;
//        this.totalSeats = totalSeats;
//    }
//
//    @Override
//    public void execute() {
//        // Add a new flight (trip) to the model
//        model.addFlight(company, origin, destination, totalSeats);
//    }
//}
//
