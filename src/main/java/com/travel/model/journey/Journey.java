package com.travel.model.journey;
import java.time.LocalDateTime;
import com.travel.model.vehicle.*;
import com.travel.model.company.*;
import com.travel.model.hub.*;
import com.travel.visitor.*;

// Journey.java

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

public abstract class Journey implements Visitable{
    private final String id;
    private final LocalDateTime departureDateTime;
    private final LocalDateTime arrivalDateTime;
    protected Vehicle vehicle;
    private final List<Hub> hubs;

    public Journey(String id,
                   LocalDateTime departureDateTime,
                   LocalDateTime arrivalDateTime,
                   Vehicle vehicle,
                   List<Hub> hubs) {
        this.id = id;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.vehicle = vehicle;
        this.hubs = hubs;
    }

    public Duration getDuration() {
        return Duration.between(departureDateTime, arrivalDateTime);
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Hub> getHubs() {
        return hubs;
    }

    public Hub getDeparture() {
        return hubs.get(0);
    }

    public Hub getArrival() {
        return hubs.get(hubs.size()-1);
    }

    @Override
    public abstract void accept(Visitor visitor);

    @Override
    public String toString() {
        return "Journey{" +
                "arrivalDateTime=" + arrivalDateTime +
                ", departureDateTime=" + departureDateTime +
                ", hubs=" + hubs +
                ", id='" + id + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}

