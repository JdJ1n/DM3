package com.travel.model.seat;

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
        throw new IllegalStateException("Cannot cancel confirmed seat");
    }

    @Override
    public void expire(Seat seat) {
        seat.setState(new ExpiredState());
    }
}
