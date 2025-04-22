// com/travel/model/reservation/state/PaidState.java
package com.travel.model.reservation.state;

import com.travel.model.reservation.Reservation;

public class PaidState implements ReservationState {

    @Override
    public void book(Reservation r) {
        throw new IllegalStateException("Already paid");
    }

    @Override
    public void pay(Reservation r) {
        throw new IllegalStateException("Already paid");
    }

    @Override
    public void cancel(Reservation r) {
        throw new IllegalStateException("Cannot cancel after payment");
    }

    @Override
    public String name() {
        return "PAID";
    }
}
