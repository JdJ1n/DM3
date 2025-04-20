//package com.travel.model;
//
///**
// * Represents an abstract section of a trip, such as a seating class or cabin class section.
// * Each section has a name (e.g., "Economy" or "Suite"), capacity, and base price per seat or cabin.
// */
//public abstract class Section {
//    private String name;
//    private int capacity;
//    private double basePrice;
//    private Vehicle vehicle;
//
//    /**
//     * Constructs a Section with given attributes.
//     * @param name the section name or class (must not be null/empty)
//     * @param capacity number of seats/cabins in this section (must be positive)
//     * @param basePrice base price per seat or cabin in this section (must be non-negative)
//     * @throws IllegalArgumentException if validation fails
//     */
//    public Section(String name, int capacity, double basePrice) {
//        if (name == null || name.trim().isEmpty()) {
//            throw new IllegalArgumentException("Section name cannot be null or empty.");
//        }
//        if (capacity <= 0) {
//            throw new IllegalArgumentException("Section capacity must be positive.");
//        }
//        if (basePrice < 0) {
//            throw new IllegalArgumentException("Base price cannot be negative.");
//        }
//        this.name = name;
//        this.capacity = capacity;
//        this.basePrice = basePrice;
//    }
//
//    /** @return the name of this section (e.g., class name) */
//    public String getName() {
//        return name;
//    }
//
//    /** @return the capacity (total number of seats or cabins) in this section */
//    public int getCapacity() {
//        return capacity;
//    }
//
//    /** @return the base price per seat/cabin in this section */
//    public double getBasePrice() {
//        return basePrice;
//    }
//
//    /** @return the number of available (unreserved) seats or cabins in this section */
//    public abstract int getAvailableCount();
//
//    /**
//     * Attempts to reserve a seat or cabin by its identifier.
//     * @param id the seat number or cabin identifier within this section
//     * @return true if the reservation was successful, false if not (already reserved or not found)
//     */
//    public abstract boolean reserve(String id);
//
//    /**
//     * Cancels a reservation for a given seat or cabin identifier.
//     * @param id the seat or cabin identifier to cancel
//     * @return true if the cancellation was successful, false if not (not found or not reserved)
//     */
//    public abstract boolean cancelReservation(String id);
//
//    public void setBasePrice(double basePrice) {
//        this.basePrice = basePrice;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
//}
