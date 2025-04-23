// FlightJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;

import com.travel.model.hub.Airport;
import com.travel.model.vehicle.Aircraft;
import com.travel.visitor.Visitor;

public class FlightJourney extends SimpleJourney {

    public FlightJourney(String id,
                         LocalDateTime departureDateTime,
                         LocalDateTime arrivalDateTime,
                         Aircraft vehicle,
                         Airport departureAirport,
                         Airport arrivalAirport) {
        super(id, departureDateTime, arrivalDateTime, vehicle, departureAirport, arrivalAirport);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
