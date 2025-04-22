// com/travel/model/reservation/FlightReservation.java
package com.travel.model.reservation;

import com.travel.model.journey.Journey;

import java.time.LocalDateTime;

public class FlightReservation extends Reservation {

    public FlightReservation(String referenceNumber,
                             Journey journey,
                             LocalDateTime creationDate,
                             LocalDateTime expirationDate) {
        super(referenceNumber, journey, creationDate, expirationDate);
    }

    public void getPayInfo() {
        // TODO
    }
}
