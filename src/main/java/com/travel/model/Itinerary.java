//package com.travel.model;
//
//import com.travel.model.hub.Port;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.time.LocalDateTime;
//
///**
// * Represents a cruise itinerary (a cruise trip).
// * Origin and destination must be ports and operator a cruise company.
// */
//public class Itinerary extends Trip {
//    // Track used cruise itinerary codes and counter for auto-generation
//    private static final Set<String> usedCruiseCodes = new HashSet<>();
//    private static int cruiseCounter = 0;
//
//    /**
//     * Constructs an Itinerary (cruise trip) with given details.
//     * If code is null/empty, it will be generated based on cruise line code and a sequence number.
//     * @param code the cruise trip code (may be null to auto-generate)
//     * @param company the cruise company operating this itinerary
//     * @param origin the origin port
//     * @param destination the destination port (may be same as origin for round-trip cruises)
//     * @param departureTime departure date/time
//     * @param arrivalTime arrival date/time
//     * @throws IllegalArgumentException if any parameter is invalid or code is duplicate
//     */
//    public Itinerary(String code, CruiseCompany company, Port origin, Port destination,
//                     LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        super(generateCode(code, company), company, origin, destination, departureTime, arrivalTime);
//    }
//
//    // Helper to generate or validate cruise itinerary code
//    private static String generateCode(String code, CruiseCompany company) {
//        if (code == null || code.trim().isEmpty()) {
//            cruiseCounter++;
//            code = company.getCode() + cruiseCounter;
//        }
//        if (usedCruiseCodes.contains(code)) {
//            throw new IllegalArgumentException("Cruise code \"" + code + "\" already exists.");
//        }
//        usedCruiseCodes.add(code);
//        return code;
//    }
//}
