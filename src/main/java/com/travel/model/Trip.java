//package com.travel.model;
//
//import com.travel.model.hub.Hub;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Represents an abstract travel trip (single journey) operated by a company from an origin to a destination.
// * Concrete trips include flights, cruises, and rail journeys.
// */
//public abstract class Trip {
//    private String code;
//    private Hub origin;
//    private Hub destination;
//    private LocalDateTime departureTime;
//    private LocalDateTime arrivalTime;
//    private Company operator;
//    private List<Section> sections = new ArrayList<>();
//
//    /**
//     * Constructs a Trip with the given details.
//     * @param code unique trip identifier
//     * @param operator the company operating this trip
//     * @param origin the start location
//     * @param destination the end location
//     * @param departureTime departure date/time
//     * @param arrivalTime arrival date/time
//     * @throws IllegalArgumentException if any required field is null or if departure is not before arrival
//     */
//    protected Trip(String code, Company operator, Hub origin, Hub destination,
//                   LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        if (operator == null || origin == null || destination == null || departureTime == null || arrivalTime == null) {
//            throw new IllegalArgumentException("Trip parameters cannot be null.");
//        }
//        this.code = code;
//        this.operator = operator;
//        this.origin = origin;
//        this.destination = destination;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        if (!departureTime.isBefore(arrivalTime)) {
//            throw new IllegalArgumentException("Departure time must be before arrival time.");
//        }
//    }
//
//    /** @return the unique code for this trip (e.g., flight number, cruise code) */
//    public String getCode() {
//        return code;
//    }
//
//    /** @return the company operating this trip */
//    public Company getOperator() {
//        return operator;
//    }
//
//    /** @return the origin location of the trip */
//    public Hub getOrigin() {
//        return origin;
//    }
//
//    /** @return the destination location of the trip */
//    public Hub getDestination() {
//        return destination;
//    }
//
//    /** @return the departure date/time of the trip */
//    public LocalDateTime getDepartureTime() {
//        return departureTime;
//    }
//
//    /** @return the arrival date/time of the trip */
//    public LocalDateTime getArrivalTime() {
//        return arrivalTime;
//    }
//
//    /**
//     * Adds a section (seating/cabin section) to this trip.
//     * Enforces that section names are unique per trip and section type matches the trip type.
//     * @param section the section to add (FlightSection, CruiseSection, or RailSection)
//     * @throws IllegalArgumentException if section is null, or if a section with the same name exists, or wrong section type for this trip
//     */
//    public void addSection(Section section) {
//        if (section == null) {
//            throw new IllegalArgumentException("Section cannot be null.");
//        }
//        // Ensure section type matches trip type
//        if ((this instanceof Flight && !(section instanceof FlightSection)) ||
//                (this instanceof Itinerary && !(section instanceof CruiseSection)) ||
//                (this instanceof Journey && !(section instanceof RailSection))) {
//            throw new IllegalArgumentException("Section type does not match trip type.");
//        }
//        // Ensure unique section name
//        for (Section sec : sections) {
//            if (sec.getName().equals(section.getName())) {
//                throw new IllegalArgumentException("Duplicate section name \"" + sec.getName() + "\" in trip " + code);
//            }
//        }
//        sections.add(section);
//    }
//
//    /** @return list of all sections in this trip (unmodifiable list) */
//    public List<Section> getSections() {
//        return List.copyOf(sections);
//    }
//
//    /** @return total number of available seats/cabins across all sections */
//    public int getTotalAvailable() {
//        int totalAvailable = 0;
//        for (Section sec : sections) {
//            totalAvailable += sec.getAvailableCount();
//        }
//        return totalAvailable;
//    }
//
//    /** @return the duration of the trip as a time span */
//    public Duration getDuration() {
//        return Duration.between(departureTime, arrivalTime);
//    }
//
//    @Override
//    public String toString() {
//        return operator.getCode() + " " + code + " from " + origin.getCode() + " to " + destination.getCode() +
//                " departing " + departureTime + " arriving " + arrivalTime;
//    }
//}
