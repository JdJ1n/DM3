//package com.travel.observer;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;
//
////import com.travel.command.Memento;
//import com.travel.model.*;
//import com.travel.model.hub.*;
//import com.travel.model.seat.*;
//import com.travel.util.*;
//
///**
// * TravelModel is the central model (Subject in Observer pattern).
// * It holds lists of companies, flights, journeys, and itineraries,
// * and notifies observers (GUI panels) on any data change.
// * It also serves as the Originator in the Memento pattern, providing snapshots of its state.
// */
//public class TravelModel implements Subject {
//    private List<Observer> observers;
//    //private List<Company> companies;
//    private List<Hub> hubs;
//    private List<Hub> seats;
//    //private List<Flight> flights;
//    //private List<Journey> journeys;
//    //private List<Itinerary> itineraries;
//
//    public TravelModel() {
//        observers = new ArrayList<>();
//        companies = new ArrayList<>();
//        flights = new ArrayList<>();
//        journeys = new ArrayList<>();
//        itineraries = new ArrayList<>();
//        // Populate initial data
//        //TODO
//        //DataInitializer.initialize(this);
//    }
//
//    @Override
//    public void attach(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void detach(Observer o) {
//        observers.remove(o);
//    }
//
//    @Override
//    public void notifyObservers() {
//        for (Observer o : observers) {
//            o.update(this);
//        }
//    }
///*
//    // Model operations for modifying data (each triggers notifyObservers):
//    public void addCompany(Company company) {
//        companies.add(company);
//        notifyObservers();
//    }
//
//    public void addFlight(Company company, String origin, String destination, int totalSeats) {
//        Flight flight = new Flight(IDGenerator.getNextFlightId(), company, origin, destination, totalSeats);
//        flights.add(flight);
//        notifyObservers();
//    }
//
//    public void addJourney(String origin, String destination) {
//        Journey journey = new Journey(IDGenerator.getNextJourneyId(), origin, destination);
//        journeys.add(journey);
//        notifyObservers();
//    }
//
//    public boolean addItinerary(Flight flight) {
//        if (flight.getAvailableSeats() <= 0) {
//            return false;
//        }
//        // Decrement available seats on the flight and create a new itinerary for it
//        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
//        Itinerary itinerary = new Itinerary(IDGenerator.getNextItineraryId(), flight);
//        itineraries.add(itinerary);
//        notifyObservers();
//        return true;
//    }
//
//    public boolean addItinerary(Journey journey) {
//        Itinerary itinerary = new Itinerary(IDGenerator.getNextItineraryId(), journey);
//        itineraries.add(itinerary);
//        notifyObservers();
//        return true;
//    }
//
//    public void removeCompany(Company company) {
//        // Remove the company
//        companies.remove(company);
//        // Remove all flights belonging to this company
//        flights.removeIf(f -> f.getCompany().equals(company));
//        // Remove any itineraries that were for flights of this company
//        itineraries.removeIf(it -> {
//            Flight f = it.getFlight();
//            return f != null && f.getCompany().equals(company);
//        });
//        notifyObservers();
//    }
//*/
//    // Accessors (return copies to avoid external modification of internal lists):
//    public List<Company> getCompanies() {
//        return new ArrayList<>(companies);
//    }
//    public List<Flight> getFlights() {
//        return new ArrayList<>(flights);
//    }
//    public List<Journey> getJourneys() {
//        return new ArrayList<>(journeys);
//    }
//    public List<Itinerary> getItineraries() {
//        return new ArrayList<>(itineraries);
//    }
//
//    // Memento pattern support (Originator role):
//    public Memento createMemento() {
//        // Deep copy the current state of the model
//        List<Company> companiesCopy = new ArrayList<>();
//        for (Company c : companies) {
//            companiesCopy.add(new Company(c.getId(), c.getName()));
//        }
//        // Map old company IDs to cloned companies for linking flights
//        Map<Integer, Company> companyMap = new HashMap<>();
//        for (Company c : companiesCopy) {
//            companyMap.put(c.getId(), c);
//        }
//
//        List<Flight> flightsCopy = new ArrayList<>();
//        Map<Integer, Flight> flightMap = new HashMap<>();
//        for (Flight f : flights) {
//            Company compClone = companyMap.get(f.getCompany().getId());
//            Flight fClone = new Flight(f.getId(), compClone, f.getOrigin(), f.getDestination(), f.getTotalSeats());
//            fClone.setAvailableSeats(f.getAvailableSeats());
//            flightsCopy.add(fClone);
//            flightMap.put(fClone.getId(), fClone);
//        }
//
//        List<Journey> journeysCopy = new ArrayList<>();
//        Map<Integer, Journey> journeyMap = new HashMap<>();
//        for (Journey j : journeys) {
//            Journey jClone = new Journey(j.getId(), j.getOrigin(), j.getDestination());
//            journeysCopy.add(jClone);
//            journeyMap.put(jClone.getId(), jClone);
//        }
//
//        List<Itinerary> itinerariesCopy = new ArrayList<>();
//        for (Itinerary it : itineraries) {
//            Itinerary itClone;
//            if (it.getFlight() != null) {
//                // Link cloned itinerary to the cloned flight
//                Flight fClone = flightMap.get(it.getFlight().getId());
//                itClone = new Itinerary(it.getId(), fClone);
//            } else if (it.getJourney() != null) {
//                Journey jClone = journeyMap.get(it.getJourney().getId());
//                itClone = new Itinerary(it.getId(), jClone);
//            } else {
//                itClone = new Itinerary(it.getId(), (Flight) null);  // shouldn't happen (itinerary always has a trip)
//            }
//            itinerariesCopy.add(itClone);
//        }
//        return new Memento(companiesCopy, flightsCopy, journeysCopy, itinerariesCopy);
//    }
//
//    public void restore(Memento memento) {
//        // Restore state from memento (for undo functionality)
//        companies = new ArrayList<>(memento.getCompanies());
//        flights = new ArrayList<>(memento.getFlights());
//        journeys = new ArrayList<>(memento.getJourneys());
//        itineraries = new ArrayList<>(memento.getItineraries());
//        notifyObservers();
//    }
//
//
//}
//
