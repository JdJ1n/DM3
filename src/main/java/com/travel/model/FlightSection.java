//package com.travel.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A section of seats on a flight, typically representing a class of service (e.g., Economy, Business).
// */
//public class FlightSection extends Section {
//    private List<Seat> seats;
//
//    /**
//     * Constructs a FlightSection with a given class name, seat capacity, and base price.
//     * Automatically creates the specified number of Seat objects (initially all available).
//     * @param name the section name or class (e.g., "Economy", "Business")
//     * @param capacity number of seats in this section
//     * @param basePrice base price per seat in this section
//     */
//    public FlightSection(String name, int capacity, double basePrice) {
//        super(name, capacity, basePrice);
//        this.seats = new ArrayList<>(capacity);
//        // Generate seat identifiers and create seats
//        for (int i = 1; i <= capacity; i++) {
//            String seatId = name.replaceAll("\\s+", "") + i;
//            Seat seat = new Seat(seatId);
//            this.seats.add(seat);
//        }
//    }
//
//    @Override
//    public int getAvailableCount() {
//        int count = 0;
//        for (Seat seat : seats) {
//            if (seat.isAvailable()) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    @Override
//    public boolean reserve(String id) {
//        for (Seat seat : seats) {
//            if (seat.getId().equals(id)) {
//                return seat.reserve();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean cancelReservation(String id) {
//        for (Seat seat : seats) {
//            if (seat.getId().equals(id)) {
//                return seat.cancelReservation();
//            }
//        }
//        return false;
//    }
//
//    /** @return list of seats in this section */
//    public List<Seat> getSeats() {
//        return List.copyOf(seats);
//    }
//}
