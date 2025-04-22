// CruiseJourney.java
package com.travel.model.journey;

import java.util.List;

import com.travel.model.vehicle.Vehicle;

public class CruiseJourney extends MultipleJourney {

    public CruiseJourney(String id,
                         List<Journey> subJourneys,
                         Vehicle vehicle) {
        super(id, subJourneys, vehicle);
    }

    // TODO
}
