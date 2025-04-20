//package com.travel.factory;
//
//import com.travel.model.*;
//import com.travel.model.hub.Hub;
//import com.travel.model.hub.Station;
//
//import java.time.LocalDateTime;
//
///**
// * Factory for creating rail travel related objects (RailLine, Station, Journey, RailSection).
// * Implemented as a singleton.
// */
//public class RailTravelFactory implements TravelFactory {
//    private static final RailTravelFactory instance = new RailTravelFactory();
//    private RailTravelFactory() {}
//
//    /** @return the singleton instance of RailTravelFactory */
//    public static RailTravelFactory getInstance() {
//        return instance;
//    }
//
//    @Override
//    public Company createCompany(String code, String name) {
//        return new RailLine(code, name);
//    }
//
//    @Override
//    public Hub createLocation(String code, String name) {
//        return new Station(code);
//    }
//
//    @Override
//    public Trip createTrip(String code, Company company, Hub origin, Hub destination,
//                           LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        if (!(company instanceof RailLine) || !(origin instanceof Station) || !(destination instanceof Station)) {
//            throw new IllegalArgumentException("Invalid types for creating Rail Journey.");
//        }
//        return new Journey(code, (RailLine) company, (Station) origin, (Station) destination, departureTime, arrivalTime);
//    }
//
//    @Override
//    public Section createSection(String name, int capacity, double basePrice) {
//        return new RailSection(name, capacity, basePrice);
//    }
//}
