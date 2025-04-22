// 文件：com/travel/factory/JourneyFactory.java
package com.travel.factory;

import com.travel.model.hub.Airport;
import com.travel.model.journey.*;
import com.travel.model.vehicle.Vehicle;
import com.travel.model.hub.Hub;

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
                                             Vehicle vehicle,
                                             Airport departureAirport,
                                             Airport arrivalAirport) {
        return new FlightJourney(id, departure, arrival, vehicle, departureAirport, arrivalAirport);
    }
    

//    public CruiseJourney createCruiseJourney(String id,
//                                                 List<Journey> subJourneys,
//                                                 Vehicle vehicle) {
//        return new CruiseJourney(id, subJourneys, vehicle);
//    }
//
//    public CruiseJourney createCruiseJourney(String id,
//                                                 Vehicle vehicle,
//                                                 Journey... subJourneys) {
//        return new CruiseJourney(id, Arrays.asList(subJourneys), vehicle);
//    }
//
//    public TrainJourney createTrainJourney(String id,
//                                             List<Journey> subJourneys,
//                                             Vehicle vehicle) {
//        return new TrainJourney(id, subJourneys, vehicle);
//    }
//
//    public TrainJourney createTrainJourney(String id,
//                                             Vehicle vehicle,
//                                             Journey... subJourneys) {
//        return new TrainJourney(id, Arrays.asList(subJourneys), vehicle);
//    }
}
