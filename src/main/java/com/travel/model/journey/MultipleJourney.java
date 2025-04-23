// MultipleJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.travel.model.vehicle.Vehicle;
import com.travel.model.hub.Hub;
import com.travel.visitor.Visitor;

public abstract class MultipleJourney extends Journey {

    public MultipleJourney(String id,
                         LocalDateTime departureDateTime,
                         LocalDateTime arrivalDateTime,
                         Vehicle vehicle,
                         List<Hub> hubs) {
        super(id,
                departureDateTime,
                arrivalDateTime,
                vehicle,
                hubs);
    }

    public abstract void accept(Visitor visitor);
}
