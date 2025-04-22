package com.travel.model.seat.state;

import com.travel.model.seat.Seat;

public class AvailableState implements SeatState {
    @Override
    public void book(Seat seat) {
        seat.setState(new ReservedState());
    }

    @Override
    public void pay(Seat seat) {
        throw new IllegalStateException("Cannot pay for an available seat");
    }

    @Override
    public void cancel(Seat seat) {
        // Do nothing
    }

    @Override
    public void unlock(Seat seat) {
        // Do nothing
    }

    @Override
    public void lock(Seat seat) {
        seat.setState(new UnavailableState());
    }
}
