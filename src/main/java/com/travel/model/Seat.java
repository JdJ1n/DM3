//package com.travel.model;
//
///**
// * Represents a seat (for flights or trains) that can be reserved.
// * Uses a state pattern to handle reservation status.
// */
//public class Seat {
//    private String id;
//    private SeatState state;
//
//    /**
//     * Constructs a Seat with a given identifier.
//     * Initially, the seat state is available (not reserved).
//     * @param id the seat identifier (e.g., seat number or code)
//     */
//    public Seat(String id) {
//        if (id == null || id.trim().isEmpty()) {
//            throw new IllegalArgumentException("Seat id cannot be null or empty.");
//        }
//        this.id = id;
//        this.state = SeatState.AVAILABLE; // start as available
//    }
//
//    /** @return the seat identifier */
//    public String getId() {
//        return id;
//    }
//
//    /** @return true if this seat is currently available (not reserved) */
//    public boolean isAvailable() {
//        return state == SeatState.AVAILABLE;
//    }
//
//    /**
//     * Attempts to reserve this seat.
//     * @return true if the seat was successfully reserved, false if it was already reserved
//     */
//    public boolean reserve() {
//        return state.reserve(this);
//    }
//
//    /**
//     * Cancels the reservation of this seat.
//     * @return true if the seat was successfully made available, false if it was not reserved
//     */
//    public boolean cancelReservation() {
//        return state.cancel(this);
//    }
//
//    // Package-private setter used by SeatState to change the seat's state
//    void setState(SeatState newState) {
//        this.state = newState;
//    }
//
//    @Override
//    public String toString() {
//        return "Seat[" + id + "," + (isAvailable() ? "Available" : "Reserved") + "]";
//    }
//}
