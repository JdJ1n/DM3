//package com.travel.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A section of cabins on a cruise, typically representing a category of cabin (e.g., Interior, Oceanview, Suite).
// */
//public class CruiseSection extends Section {
//    private List<Cabin> cabins;
//
//    /**
//     * Constructs a CruiseSection with a given category name, cabin count, and base price.
//     * Automatically creates the specified number of Cabin objects (initially all available).
//     * @param name the cabin category name (e.g., "Interior", "Suite")
//     * @param capacity number of cabins in this section
//     * @param basePrice base price per cabin in this section
//     */
//    public CruiseSection(String name, int capacity, double basePrice) {
//        super(name, capacity, basePrice);
//        this.cabins = new ArrayList<>(capacity);
//        // Generate cabin identifiers and create cabins
//        for (int i = 1; i <= capacity; i++) {
//            String cabinId = name.replaceAll("\\s+", "") + i;
//            Cabin cabin = new Cabin(cabinId);
//            this.cabins.add(cabin);
//        }
//    }
//
//    @Override
//    public int getAvailableCount() {
//        int count = 0;
//        for (Cabin cabin : cabins) {
//            if (cabin.isAvailable()) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    @Override
//    public boolean reserve(String id) {
//        for (Cabin cabin : cabins) {
//            if (cabin.getId().equals(id)) {
//                return cabin.reserve();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean cancelReservation(String id) {
//        for (Cabin cabin : cabins) {
//            if (cabin.getId().equals(id)) {
//                return cabin.cancelReservation();
//            }
//        }
//        return false;
//    }
//
//    /** @return list of cabins in this section */
//    public List<Cabin> getCabins() {
//        return List.copyOf(cabins);
//    }
//}
