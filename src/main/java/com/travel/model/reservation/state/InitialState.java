// com/travel/model/reservation/state/InitialState.java
package com.travel.model.reservation.state;

import com.travel.model.reservation.Reservation;

public class InitialState implements ReservationState {

    @Override
    public void book(Reservation r) {
        // TODO:
        r.setState(new ReservedState());
    }

    @Override
    public void pay(Reservation r) {
        throw new IllegalStateException("Cannot pay before booking");
    }

    @Override
    public void cancel(Reservation r) {
        throw new IllegalStateException("Cannot cancel before booking");
    }

    @Override
    public String name() {
        return "UNBOOKED";
    }
}
