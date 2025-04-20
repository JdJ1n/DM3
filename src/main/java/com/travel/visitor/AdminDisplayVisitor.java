//package com.travel.visitor;
//
//
///**
// * Visitor implementation for admin display.
// * Provides detailed string representations of travel entities for the admin view.
// */
//public class AdminDisplayVisitor implements TravelEntityVisitor {
//    @Override
//    public String visitFlight(Flight flight) {
//        // Include ID, company, route, and seat availability (available/total)
//        Company comp = flight.getCompany();
//        String compName = (comp != null ? comp.getName() : "N/A");
//        return String.format("Flight %d (%s): %s -> %s, Seats: %d/%d",
//                flight.getId(), compName, flight.getOrigin(),
//                flight.getDestination(), flight.getAvailableSeats(), flight.getTotalSeats());
//    }
//
//    @Override
//    public String visitJourney(Journey journey) {
//        // Include journey ID and route
//        return String.format("Journey %d: %s -> %s",
//                journey.getId(), journey.getOrigin(), journey.getDestination());
//    }
//
//    @Override
//    public String visitItinerary(Itinerary itinerary) {
//        // If itinerary is for a flight, include flight and company; if for a journey, include journey details
//        if (itinerary.getFlight() != null) {
//            Flight f = itinerary.getFlight();
//            Company comp = f.getCompany();
//            String compName = (comp != null ? comp.getName() : "N/A");
//            return String.format("Itinerary %d (Flight %d - %s): %s -> %s",
//                    itinerary.getId(), f.getId(), compName, f.getOrigin(), f.getDestination());
//        } else if (itinerary.getJourney() != null) {
//            Journey j = itinerary.getJourney();
//            return String.format("Itinerary %d (Journey %d): %s -> %s",
//                    itinerary.getId(), j.getId(), j.getOrigin(), j.getDestination());
//        }
//        return String.format("Itinerary %d: [unknown trip]", itinerary.getId());
//    }
//
//    @Override
//    public String visitCompany(Company company) {
//        // Include company ID and name
//        return String.format("Company %d: %s", company.getId(), company.getName());
//    }
//}
//
