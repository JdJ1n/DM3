package com.travel.model;

/**
 * Represents a rail operator or rail line company.
 */
public class RailLine extends Company {
    /**
     * Constructs a RailLine (railway company) with a unique code and name.
     * @param code the rail line code
     * @param name the rail company's name
     */
    public RailLine(String code, String name) {
        super(code, name);
    }
}
