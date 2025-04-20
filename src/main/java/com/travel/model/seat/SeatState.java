package com.travel.model.seat;

    public interface SeatState {
        void book(Seat seat);
        void pay(Seat seat);
        void cancel(Seat seat);
        void expire(Seat seat);
    }
