package com.travel.model.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an airline company.
 */
public class Airline extends Company {

    protected String id;
    private static final Set<String> usedCodes = new HashSet<>();

    public Airline(String code,String id) {
        super(code);
        validateCode(id);
        this.id = id;
        usedCodes.add(id);
    }

    private void validateCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline ID cannot be null or empty.");
        }
        if (code.length() != 2) {
            throw new IllegalArgumentException("Airline ID must be 2 digit.");
        }
        if (usedCodes.contains(code)) {
            throw new IllegalArgumentException("Airline ID \"" + code + "\" must be unique.");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validateCode(id);
        usedCodes.remove(this.id);
        this.id = id;
        usedCodes.add(id);
    }
}
