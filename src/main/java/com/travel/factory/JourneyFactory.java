// src/main/java/com/travel/factory/JourneyFactory.java
package com.travel.factory;

import com.travel.model.hub.Airport;
import com.travel.model.hub.Hub;
import com.travel.model.journey.CruiseJourney;
import com.travel.model.journey.FlightJourney;
import com.travel.model.journey.TrainJourney;
import com.travel.model.vehicle.Aircraft;
import com.travel.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class JourneyFactory {

    private static final JourneyFactory INSTANCE = new JourneyFactory();

    private JourneyFactory() {}

    public static JourneyFactory getInstance() {
        return INSTANCE;
    }

    public FlightJourney createFlightJourney(String id,
                                             LocalDateTime departure,
                                             LocalDateTime arrival,
                                             Aircraft vehicle,
                                             Airport departureAirport,
                                             Airport arrivalAirport) {
        return new FlightJourney(id, departure, arrival, vehicle, departureAirport, arrivalAirport);
    }

    public TrainJourney createTrainJourney(String id,
                                           LocalDateTime departure,
                                           LocalDateTime arrival,
                                           Vehicle vehicle,
                                           Hub departureStation,
                                           Hub arrivalStation) {
        return new TrainJourney(id, departure, arrival, vehicle,
                List.of(departureStation, arrivalStation));
    }

    public CruiseJourney createCruiseJourney(String id,
                                             LocalDateTime departure,
                                             LocalDateTime arrival,
                                             Vehicle vehicle,
                                             Hub departurePort,
                                             Hub arrivalPort) {
        return new CruiseJourney(id, departure, arrival, vehicle,
                List.of(departurePort, arrivalPort));
    }

}
