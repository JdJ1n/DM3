// FlightJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;

import com.travel.model.hub.Airport;
import com.travel.model.vehicle.Vehicle;
import com.travel.model.hub.Hub;

public class FlightJourney extends SimpleJourney {

    public FlightJourney(String id,
                         LocalDateTime departureDateTime,
                         LocalDateTime arrivalDateTime,
                         Vehicle vehicle,
                         Airport departureAirport,
                         Airport arrivalAirport) {
        super(id, departureDateTime, arrivalDateTime, vehicle, departureAirport, arrivalAirport);
    }

    // TODO:
}
