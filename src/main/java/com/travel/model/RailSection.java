//package com.travel.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A section of seats on a train, typically representing a class of service or car type (e.g., First Class, Sleeper).
// */
//public class RailSection extends Section {
//    private List<Seat> seats;
//
//    /**
//     * Constructs a RailSection with a given class name, seat capacity, and base price.
//     * Automatically creates the specified number of Seat objects.
//     * @param name the section name or class (e.g., "First Class", "Coach")
//     * @param capacity number of seats in this section
//     * @param basePrice base price per seat in this section
//     */
//    public RailSection(String name, int capacity, double basePrice) {
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
