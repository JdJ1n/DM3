// com/travel/model/reservation/TrainReservation.java
package com.travel.model.reservation;

import com.travel.model.journey.Journey;

import java.time.LocalDateTime;

public class TrainReservation extends Reservation {

    public TrainReservation(String referenceNumber,
                            Journey journey,
                            LocalDateTime creationDate,
                            LocalDateTime expirationDate) {
        super(referenceNumber, journey, creationDate, expirationDate);
    }

    public void getPayInfo() {
        // TODO
    }
}
