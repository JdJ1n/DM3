package com.travel.model.seat.state;

import com.travel.model.seat.Seat;

public class ConfirmedState implements SeatState {
    @Override
    public void book(Seat seat) {
        throw new IllegalStateException("Already confirmed");
    }

    @Override
    public void pay(Seat seat) {
        throw new IllegalStateException("Already paid");
    }

    @Override
    public void cancel(Seat seat) {
        seat.setState(new AvailableState());
    }

    @Override
    public void lock(Seat seat) {
        seat.setState(new UnavailableState());
    }

    @Override
    public void unlock(Seat seat) {

    }
}
