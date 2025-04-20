//package com.travel.model;
//
//import com.travel.model.hub.Airport;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.time.LocalDateTime;
//
///**
// * Represents a flight (air travel trip).
// * Origin and destination must be airports and operator an airline.
// */
//public class Flight extends Trip {
//    // Track used flight codes and counter for auto-generation
//    private static final Set<String> usedFlightCodes = new HashSet<>();
//    private static int flightCounter = 0;
//
//    /**
//     * Constructs a Flight with given details.
//     * If code is null/empty, it will be generated based on airline code and a sequence number.
//     * @param code the flight number or code (may be null to auto-generate)
//     * @param company the airline operating the flight
//     * @param origin the origin airport
//     * @param destination the destination airport
//     * @param departureTime departure date/time
//     * @param arrivalTime arrival date/time
//     * @throws IllegalArgumentException if any parameter is invalid or code is duplicate
//     */
//    public Flight(String code, AirCompany company, Airport origin, Airport destination,
//                  LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        super(generateCode(code, company), company, origin, destination, departureTime, arrivalTime);
//    }
//
//    // Helper to generate or validate flight code
//    private static String generateCode(String code, AirCompany company) {
//        if (code == null || code.trim().isEmpty()) {
//            flightCounter++;
//            code = company.getCode() + flightCounter;
//        }
//        if (usedFlightCodes.contains(code)) {
//            throw new IllegalArgumentException("Flight code \"" + code + "\" already exists.");
//        }
//        usedFlightCodes.add(code);
//        return code;
//    }
//
//}
