package com.travel.model.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Company {
    protected String code;
    private static final Set<String> usedCodes = new HashSet<>();

    public Company(String code) {
        validateCode(code);
        this.code = code;
        usedCodes.add(code);
    }

    private void validateCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Company code cannot be null or empty.");
        }
        if (code.length() > 6) {
            throw new IllegalArgumentException("Company code must be less than 6 digit.");
        }
        if (usedCodes.contains(code)) {
            throw new IllegalArgumentException("Company code \"" + code + "\" must be unique.");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        validateCode(code);
        usedCodes.remove(this.code);
        this.code = code;
        usedCodes.add(code);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(code, company.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
