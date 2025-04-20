package com.travel.model;

/**
 * Represents an airline company.
 */
public class AirCompany extends Company {
    /**
     * Constructs an AirCompany (airline) with a unique code and name.
     * @param code the airline code (e.g., IATA airline code)
     * @param name the airline's name
     */
    public AirCompany(String code, String name) {
        super(code, name);
    }
}
