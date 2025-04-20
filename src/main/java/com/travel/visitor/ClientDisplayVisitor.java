//package com.travel.visitor;
//
//
///**
// * Visitor implementation for client display.
// * Provides user-friendly string representations of travel entities for the client view.
// */
//public class ClientDisplayVisitor implements TravelEntityVisitor {
//    @Override
//    public String visitFlight(Flight flight) {
//        // Show route and airline, and indicate available seats or FULL
//        String compName = (flight.getCompany() != null ? flight.getCompany().getName() : "Unknown");
//        String info = String.format("Flight: %s -> %s (%s)",
//                flight.getOrigin(), flight.getDestination(), compName);
//        if (flight.getAvailableSeats() <= 0) {
//            return info + " - FULL";
//        } else {
//            return info + " - Seats available: " + flight.getAvailableSeats();
//        }
//    }
//
//    @Override
//    public String visitJourney(Journey journey) {
//        // Show trip route for client (treat journey as a trip offering)
//        return String.format("Trip: %s -> %s", journey.getOrigin(), journey.getDestination());
//    }
//
//    @Override
//    public String visitItinerary(Itinerary itinerary) {
//        // Show reservation details: flight or journey route
//        if (itinerary.getFlight() != null) {
//            Flight f = itinerary.getFlight();
//            return String.format("Booking #%d: Flight %d %s -> %s",
//                    itinerary.getId(), f.getId(), f.getOrigin(), f.getDestination());
//        } else if (itinerary.getJourney() != null) {
//            Journey j = itinerary.getJourney();
//            return String.format("Booking #%d: Trip %d %s -> %s",
//                    itinerary.getId(), j.getId(), j.getOrigin(), j.getDestination());
//        }
//        return String.format("Booking #%d: [unknown trip]", itinerary.getId());
//    }
//
//    @Override
//    public String visitCompany(Company company) {
//        // Clients only need to see company name (if at all)
//        return company.getName();
//    }
//}
//
