package com.travel.model.section;

import com.travel.model.seat.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A section of cabins on a cruise, typically representing a category of cabin (e.g., Interior, Oceanview, Suite).
 */
public class CruiseSection extends Section {
    private List<CruiseCabin> cabins;

    /**
     * Constructs a CruiseSection with a given category name, cabin count, and base price.
     * Automatically creates the specified number of CruiseCabin objects (initially all available).
     * @param name the cabin category name (e.g., "Interior", "Suite")
     * @param capacity number of cabins in this section
     * @param classe base price per cabin in this section
     */
    public CruiseSection(String name, int capacity, Classe classe) {
        super(name, capacity, classe);
        int cabinCapacity;
        if (classe.getId()=='O')
            cabinCapacity=2;
        else if (classe.getId()=='I') {
            cabinCapacity=4;
        } else if (classe.getId()=='S') {
            cabinCapacity=5;
        } else if (classe.getId()=='F') {
            cabinCapacity=6;
        }else throw new IllegalArgumentException("Invalid classe");

        this.cabins = new ArrayList<>(capacity);
        // Generate cabin identifiers and create cabins
        for (int i = 1; i <= capacity; i++) {
            CruiseCabin cabin = new CruiseCabin(cabinCapacity,i);
            this.cabins.add(cabin);
        }
    }

    @Override
    public int getAvailableCount() {
        int count = 0;
        for (CruiseCabin cabin : cabins) {
            if (cabin.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean book(String id) {
        for (CruiseCabin cabin : cabins) {
            if (String.valueOf(cabin.getId()).equals(id)) {
                return cabin.book();
            }
        }
        return false;
    }

    @Override
    public boolean pay(String id) {
        for (CruiseCabin cabin : cabins) {
            if (String.valueOf(cabin.getId()).equals(id)) {
                return cabin.pay();
            }
        }
        return false;
    }

    @Override
    public boolean cancel(String id) {
        for (CruiseCabin cabin : cabins) {
            if (String.valueOf(cabin.getId()).equals(id)) {
                return cabin.cancel();
            }
        }
        return false;
    }

    @Override
    public boolean lock(String id) {
        for (CruiseCabin cabin : cabins) {
            if (String.valueOf(cabin.getId()).equals(id)) {
                return cabin.lock();
            }
        }
        return false;
    }

    @Override
    public boolean unlock(String id) {
        for (CruiseCabin cabin : cabins) {
            if (String.valueOf(cabin.getId()).equals(id)) {
                return cabin.unlock();
            }
        }
        return false;
    }

    /** @return list of cabins in this section */
    public List<CruiseCabin> getCruiseCabins() {
        return List.copyOf(cabins);
    }
}
