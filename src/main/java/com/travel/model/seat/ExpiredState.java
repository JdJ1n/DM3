package com.travel.model.seat;

public class ExpiredState implements SeatState {
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
    public void expire(Seat seat) {
        // Do nothing
    }
}
