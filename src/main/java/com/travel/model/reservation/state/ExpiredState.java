// com/travel/model/reservation/state/ExpiredState.java
package com.travel.model.reservation.state;

import com.travel.model.reservation.Reservation;

public class ExpiredState implements ReservationState {

    @Override
    public void book(Reservation r) {
        throw new IllegalStateException("Cannot rebook an expired reservation");
    }

    @Override
    public void pay(Reservation r) {
        throw new IllegalStateException("Cannot pay an expired reservation");
    }

    @Override
    public void cancel(Reservation r) {
        throw new IllegalStateException("Already expired/cancelled");
    }

    @Override
    public String name() {
        return "EXPIRED";
    }
}
