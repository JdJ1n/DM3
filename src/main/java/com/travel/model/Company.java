package com.travel.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a generic travel company (airline, cruise line, or rail operator).
 * Each company has a unique code identifier.
 */
public abstract class Company {
    private String code;
    private String name;
    // static set to ensure unique company codes
    private static final Set<String> usedCodes = new HashSet<>();

    /**
     * Constructs a Company with a unique code and name.
     * @param code unique code for the company (e.g., airline code)
     * @param name full name of the company
     * @throws IllegalArgumentException if code is null/empty or not unique
     */
    public Company(String code, String name) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Company code cannot be null or empty.");
        }
        if (usedCodes.contains(code)) {
            throw new IllegalArgumentException("Company code \"" + code + "\" must be unique.");
        }
        usedCodes.add(code);
        this.code = code;
        this.name = name;
    }

    /** @return the unique company code */
    public String getCode() {
        return code;
    }

    /** @return the company name */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}
