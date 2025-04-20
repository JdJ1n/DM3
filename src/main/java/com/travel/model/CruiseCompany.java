package com.travel.model;

/**
 * Represents a cruise line company.
 */
public class CruiseCompany extends Company {
    /**
     * Constructs a CruiseCompany (cruise line) with a unique code and name.
     * @param code the cruise line code
     * @param name the cruise line's name
     */
    public CruiseCompany(String code, String name) {
        super(code, name);
    }
}
