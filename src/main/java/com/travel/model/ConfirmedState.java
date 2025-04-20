//package com.travel.model;
//
//public class ConfirmedState implements ReservationState {
//    @Override
//    public void book(Reservation reservation) {
//        System.out.println("Already confirmed.");
//    }
//
//    @Override
//    public void pay(Reservation reservation) {
//        System.out.println("Already confirmed.");
//    }
//
//    @Override
//    public void confirm(Reservation reservation) {
//        System.out.println("Already confirmed.");
//    }
//
//    @Override
//    public void expire(Reservation reservation) {
//        reservation.setState(new ExpiredState());
//        System.out.println("Reservation expired.");
//    }
//
//    @Override
//    public void cancel(Reservation reservation) {
//        reservation.setState(new ExpiredState());
//        System.out.println("Reservation cancelled.");
//    }
//}
