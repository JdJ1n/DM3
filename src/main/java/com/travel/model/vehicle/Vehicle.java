package com.travel.model.vehicle;
import com.travel.model.section.*;
import com.travel.model.company.*;

public abstract class Vehicle {
    protected String type;
    private Company company;

    public Vehicle(Company company, String type) {
        this.company = company;
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "company=" + company +
                ", type='" + type + '\'' +
                '}';
    }
}
