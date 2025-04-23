// SimpleJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.travel.model.vehicle.Vehicle;
import com.travel.model.hub.Hub;
import com.travel.visitor.Visitor;

public abstract class SimpleJourney extends Journey {

    public SimpleJourney(String id,
                         LocalDateTime departureDateTime,
                         LocalDateTime arrivalDateTime,
                         Vehicle vehicle,
                         Hub departureHub,
                         Hub arrivalHub) {
        super(id,
                departureDateTime,
                arrivalDateTime,
                vehicle,
                Arrays.asList(departureHub, arrivalHub));
    }

    public abstract void accept(Visitor visitor);
}
