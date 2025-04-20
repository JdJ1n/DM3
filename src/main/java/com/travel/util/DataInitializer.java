//package com.travel.util;
//
///**
// * DataInitializer populates the TravelModel with initial data for the demo:
// * 3 companies, 3 flights, 3 journeys, and 3 itineraries (two flight reservations and one journey reservation).
// */
//public class DataInitializer {
//    public static void initialize(TravelModel model) {
//        // Create companies
//        Company comp1 = new Company(IDGenerator.getNextCompanyId(), "Airline A");
//        Company comp2 = new Company(IDGenerator.getNextCompanyId(), "Airline B");
//        Company comp3 = new Company(IDGenerator.getNextCompanyId(), "Airline C");
//        model.addCompany(comp1);
//        model.addCompany(comp2);
//        model.addCompany(comp3);
//
//        // Create flights (each flight under one company)
//        model.addFlight(comp1, "Montreal", "Toronto", 10);    // Flight 1: 10 seats
//        model.addFlight(comp2, "New York", "London", 5);      // Flight 2: 5 seats
//        model.addFlight(comp3, "Sydney", "Tokyo", 2);         // Flight 3: 2 seats
//
//        // Create journeys (multi-leg trips not tied to a single flight)
//        model.addJourney("Montreal", "London");   // Journey 1
//        model.addJourney("Toronto", "Sydney");    // Journey 2
//        model.addJourney("New York", "Tokyo");    // Journey 3
//
//        // Create initial itineraries (reservations):
//        // Reserve one seat on Flight 1 and Flight 2
//        Flight f1 = model.getFlights().get(0);
//        Flight f2 = model.getFlights().get(1);
//        model.addItinerary(f1);
//        model.addItinerary(f2);
//        // Reserve one Journey (Journey 1)
//        Journey j1 = model.getJourneys().get(0);
//        model.addItinerary(j1);
//    }
//}
//
