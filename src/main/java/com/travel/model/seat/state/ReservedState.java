package com.travel.model.seat.state;

import com.travel.model.seat.Seat;

import java.util.Timer;
import java.util.TimerTask;

public class ReservedState implements SeatState {
    public ReservedState() {
        scheduleAutoCancel();
    }

    public void scheduleAutoCancel() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                cancel();
            }
        }, 24 * 60 * 60 * 1000);
    }

    @Override
    public void book(Seat seat) {
        throw new IllegalStateException("Already reserved");
    }

    @Override
    public void pay(Seat seat) {
        seat.setState(new ConfirmedState());
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
