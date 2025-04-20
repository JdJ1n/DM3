//package com.travel.model;
//
///**
// * State pattern for Seat reservation status.
// * Defines behavior for reserving and canceling based on current state.
// */
//public abstract class SeatState {
//    /** Attempts to reserve the given seat in this state. */
//    public abstract boolean reserve(Seat seat);
//    /** Attempts to cancel a reservation of the given seat in this state. */
//    public abstract boolean cancel(Seat seat);
//
//    /** State indicating the seat is available for reservation. */
//    public static final SeatState AVAILABLE = new SeatState() {
//        @Override
//        public boolean reserve(Seat seat) {
//            // Transition from available to reserved
//            seat.setState(SeatState.RESERVED);
//            return true;
//        }
//        @Override
//        public boolean cancel(Seat seat) {
//            // Already available, cannot cancel
//            return false;
//        }
//        @Override
//        public String toString() { return "Available"; }
//    };
//
//    /** State indicating the seat is currently reserved. */
//    public static final SeatState RESERVED = new SeatState() {
//        @Override
//        public boolean reserve(Seat seat) {
//            // Already reserved, cannot reserve again
//            return false;
//        }
//        @Override
//        public boolean cancel(Seat seat) {
//            // Transition from reserved to available
//            seat.setState(SeatState.AVAILABLE);
//            return true;
//        }
//        @Override
//        public String toString() { return "Reserved"; }
//    };
//}
