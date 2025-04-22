package com.travel.model.seat.state;

import com.travel.model.seat.Seat;

public interface SeatState {
        void book(Seat seat);
        void pay(Seat seat);
        void cancel(Seat seat);
        void lock(Seat seat);
        void unlock(Seat seat);
    }
