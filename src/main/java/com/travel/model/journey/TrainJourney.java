// TrainJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;
import java.util.List;

import com.travel.model.hub.Hub;
import com.travel.model.vehicle.Vehicle;

public class TrainJourney extends MultipleJourney {

    public TrainJourney(String id,
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

    // TODO
}
