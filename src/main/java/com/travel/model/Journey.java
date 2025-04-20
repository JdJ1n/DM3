//package com.travel.model;
//
//import com.travel.model.hub.Station;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.time.LocalDateTime;
//
///**
// * Represents a rail journey (train trip).
// * Origin and destination must be stations and operator a rail line company.
// */
//public class Journey extends Trip {
//    // Track used rail journey codes and counter for auto-generation
//    private static final Set<String> usedRailCodes = new HashSet<>();
//    private static int railCounter = 0;
//
//    /**
//     * Constructs a Journey (rail trip) with given details.
//     * If code is null/empty, it will be generated based on rail line code and a sequence number.
//     * @param code the journey code (train identifier, may be null to auto-generate)
//     * @param company the rail line company operating this journey
//     * @param origin the origin station
//     * @param destination the destination station
//     * @param departureTime departure date/time
//     * @param arrivalTime arrival date/time
//     * @throws IllegalArgumentException if any parameter is invalid or code is duplicate
//     */
//    public Journey(String code, RailLine company, Station origin, Station destination,
//                   LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        super(generateCode(code, company), company, origin, destination, departureTime, arrivalTime);
//    }
//
//    // Helper to generate or validate rail journey code
//    private static String generateCode(String code, RailLine company) {
//        if (code == null || code.trim().isEmpty()) {
//            railCounter++;
//            code = company.getCode() + railCounter;
//        }
//        if (usedRailCodes.contains(code)) {
//            throw new IllegalArgumentException("Rail journey code \"" + code + "\" already exists.");
//        }
//        usedRailCodes.add(code);
//        return code;
//    }
//}
