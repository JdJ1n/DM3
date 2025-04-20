//package com.travel.model;
//
///**
// * State pattern for Cabin reservation status.
// * Defines behavior for reserving and canceling based on current state.
// */
//public abstract class CabinState {
//    /** Attempts to reserve the given cabin in this state. */
//    public abstract boolean reserve(Cabin cabin);
//    /** Attempts to cancel a reservation of the given cabin in this state. */
//    public abstract boolean cancel(Cabin cabin);
//
//    /** State indicating the cabin is available (not reserved). */
//    public static final CabinState AVAILABLE = new CabinState() {
//        @Override
//        public boolean reserve(Cabin cabin) {
//            cabin.setState(CabinState.RESERVED);
//            return true;
//        }
//        @Override
//        public boolean cancel(Cabin cabin) {
//            return false;
//        }
//        @Override
//        public String toString() { return "Available"; }
//    };
//
//    /** State indicating the cabin is currently reserved. */
//    public static final CabinState RESERVED = new CabinState() {
//        @Override
//        public boolean reserve(Cabin cabin) {
//            return false;
//        }
//        @Override
//        public boolean cancel(Cabin cabin) {
//            cabin.setState(CabinState.AVAILABLE);
//            return true;
//        }
//        @Override
//        public String toString() { return "Reserved"; }
//    };
//}
