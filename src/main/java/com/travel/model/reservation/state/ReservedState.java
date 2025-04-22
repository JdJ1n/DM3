// com/travel/model/reservation/state/ReservedState.java
package com.travel.model.reservation.state;

import com.travel.model.reservation.Reservation;

public class ReservedState implements ReservationState {

    @Override
    public void book(Reservation r) {
        throw new IllegalStateException("Already booked");
    }

    @Override
    public void pay(Reservation r) {
        // TODO
        r.setState(new PaidState());
    }

    @Override
    public void cancel(Reservation r) {
        r.setState(new ExpiredState());
    }

    @Override
    public String name() {
        return "RESERVED";
    }
}
