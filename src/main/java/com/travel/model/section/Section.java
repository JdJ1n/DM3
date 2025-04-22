package com.travel.model.section;

/**
 * Represents an abstract section of a trip, such as a seating class or cabin class section.
 * Each section has a name (e.g., "Economy" or "Suite"), capacity, and base price per seat or cabin.
 */
public abstract class Section {
    private String name;
    private int capacity;
    private Classe classe;

    /**
     * Constructs a Section with given attributes.
     * @param name the section name or class (must not be null/empty)
     * @param capacity number of seats/cabins in this section (must be positive)
     * @param classe base price per seat or cabin in this section (must be non-negative)
     * @throws IllegalArgumentException if validation fails
     */
    public Section(String name, int capacity, Classe classe) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Section name cannot be null or empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Section capacity must be positive.");
        }
        this.name = name;
        this.capacity = capacity;
        this.classe = classe;
    }

    /** @return the name of this section (e.g., class name) */
    public String getName() {
        return name;
    }

    /** @return the capacity (total number of seats or cabins) in this section */
    public int getCapacity() {
        return capacity;
    }


    /** @return the number of available (unreserved) seats or cabins in this section */
    public abstract int getAvailableCount();

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public abstract boolean cancel(String id);

    public abstract boolean pay(String id);

    public abstract boolean book(String id);

    public abstract boolean lock(String id);

    public abstract boolean unlock(String id);
}
