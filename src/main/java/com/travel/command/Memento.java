//package com.travel.command;
//
//
//import com.travel.model.*;
//
//import java.util.List;
//
///**
// * Memento class that stores a snapshot of TravelModel's state (companies, flights, journeys, itineraries).
// * Used by CommandManager to implement undo functionality.
// */
//public class Memento {
//    private List<Company> companies;
//    private List<Flight> flights;
//    private List<Journey> journeys;
//    private List<Itinerary> itineraries;
//
//    public Memento(List<Company> companies, List<Flight> flights,
//                   List<Journey> journeys, List<Itinerary> itineraries) {
//        this.companies = companies;
//        this.flights = flights;
//        this.journeys = journeys;
//        this.itineraries = itineraries;
//    }
//
//    public List<Company> getCompanies() {
//        return companies;
//    }
//    public List<Flight> getFlights() {
//        return flights;
//    }
//    public List<Journey> getJourneys() {
//        return journeys;
//    }
//    public List<Itinerary> getItineraries() {
//        return itineraries;
//    }
//}
//
