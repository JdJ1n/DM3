//package com.travel.factory;
//
//import com.travel.model.*;
//import com.travel.model.hub.Airport;
//import com.travel.model.hub.Hub;
//
//import java.time.LocalDateTime;
//
///**
// * Factory for creating air travel related objects (AirCompany, Airport, Flight, FlightSection).
// * Implemented as a singleton.
// */
//public class AirTravelFactory implements TravelFactory {
//    private static final AirTravelFactory instance = new AirTravelFactory();
//    private AirTravelFactory() {} // private constructor
//
//    /** @return the singleton instance of AirTravelFactory */
//    public static AirTravelFactory getInstance() {
//        return instance;
//    }
//
//    @Override
//    public Company createCompany(String code, String name) {
//        return new AirCompany(code, name);
//    }
//
//    @Override
//    public Hub createLocation(String code, String name) {
//        return new Airport(code);
//    }
//
//    @Override
//    public Trip createTrip(String code, Company company, Hub origin, Hub destination,
//                           LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        if (!(company instanceof AirCompany) || !(origin instanceof Airport) || !(destination instanceof Airport)) {
//            throw new IllegalArgumentException("Invalid types for creating Flight.");
//        }
//        return new Flight(code, (AirCompany) company, (Airport) origin, (Airport) destination, departureTime, arrivalTime);
//    }
//
//    @Override
//    public Section createSection(String name, int capacity, double basePrice) {
//        return new FlightSection(name, capacity, basePrice);
//    }
//}
