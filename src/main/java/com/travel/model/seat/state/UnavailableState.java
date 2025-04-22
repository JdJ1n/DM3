package com.travel.model.seat.state;

import com.travel.model.seat.Seat;

public class UnavailableState implements SeatState {
    @Override
    public void book(Seat seat) {
        // Do nothing
    }

    @Override
    public void pay(Seat seat) {
        // Do nothing
    }

    @Override
    public void cancel(Seat seat) {
        // Do nothing
    }

    @Override
    public void unlock(Seat seat) {
        seat.setState(new AvailableState());
    }

    @Override
    public void lock(Seat seat) {
        // Do nothing
    }
}
