package com.travel.util;

/**
 * Utility class for generating unique IDs for different entity types
 * (Company, Flight, Journey, Itinerary).
 */
public class IDGenerator {
    private static int companyCounter = 0;
    private static int flightCounter = 0;
    private static int journeyCounter = 0;
    private static int itineraryCounter = 0;

    public static int getNextCompanyId() {
        return ++companyCounter;
    }
    public static int getNextFlightId() {
        return ++flightCounter;
    }
    public static int getNextJourneyId() {
        return ++journeyCounter;
    }
    public static int getNextItineraryId() {
        return ++itineraryCounter;
    }
}

