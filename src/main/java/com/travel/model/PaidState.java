//package com.travel.model;
//
//public class PaidState implements ReservationState {
//    @Override
//    public void book(Reservation reservation) {
//        System.out.println("Already paid. Cannot re-book.");
//    }
//
//    @Override
//    public void pay(Reservation reservation) {
//        System.out.println("Already paid.");
//    }
//
//    @Override
//    public void confirm(Reservation reservation) {
//        reservation.setState(new ConfirmedState());
//        System.out.println("Reservation confirmed.");
//    }
//
//    @Override
//    public void expire(Reservation reservation) {
//        reservation.setState(new ExpiredState());
//        System.out.println("Payment expired.");
//    }
//
//    @Override
//    public void cancel(Reservation reservation) {
//        reservation.setState(new ExpiredState());
//        System.out.println("Reservation cancelled.");
//    }
//}
