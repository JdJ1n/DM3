// com/travel/model/reservation/Reservation.java
package com.travel.model.reservation;

import com.travel.model.journey.Journey;
import com.travel.model.reservation.state.InitialState;
import com.travel.model.reservation.state.ReservationState;
import com.travel.visitor.*;

import java.time.LocalDateTime;

public abstract class Reservation implements Visitable{
    private final String referenceNumber;
    private final Journey journey;
    private final LocalDateTime creationDate;
    private final LocalDateTime expirationDate;
    private ReservationState state;

    public Reservation(String referenceNumber,
                       Journey journey,
                       LocalDateTime creationDate,
                       LocalDateTime expirationDate) {
        this.referenceNumber = referenceNumber;
        this.journey = journey;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.state = new InitialState();
    }

    public void book() {
        state.book(this);
    }

    public void pay() {
        state.pay(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public String getStatus() {
        return state.name();
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public Journey getJourney() {
        return journey;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setState(ReservationState newState) {
        this.state = newState;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", journey=" + journey +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", state=" + state +
                '}';
    }
}
