//package com.travel.factory;
//
//import com.travel.model.*;
//import com.travel.model.hub.Hub;
//import com.travel.model.hub.Port;
//
//import java.time.LocalDateTime;
//
///**
// * Factory for creating marine travel related objects (CruiseCompany, Port, Itinerary, CruiseSection).
// * Implemented as a singleton.
// */
//public class MarineTravelFactory implements TravelFactory {
//    private static final MarineTravelFactory instance = new MarineTravelFactory();
//    private MarineTravelFactory() {}
//
//    /** @return the singleton instance of MarineTravelFactory */
//    public static MarineTravelFactory getInstance() {
//        return instance;
//    }
//
//    @Override
//    public Company createCompany(String code, String name) {
//        return new CruiseCompany(code, name);
//    }
//
//    @Override
//    public Hub createLocation(String code, String name) {
//        return new Port(code);
//    }
//
//    @Override
//    public Trip createTrip(String code, Company company, Hub origin, Hub destination,
//                           LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        if (!(company instanceof CruiseCompany) || !(origin instanceof Port) || !(destination instanceof Port)) {
//            throw new IllegalArgumentException("Invalid types for creating Cruise Itinerary.");
//        }
//        return new Itinerary(code, (CruiseCompany) company, (Port) origin, (Port) destination, departureTime, arrivalTime);
//    }
//
//    @Override
//    public Section createSection(String name, int capacity, double basePrice) {
//        return new CruiseSection(name, capacity, basePrice);
//    }
//}
