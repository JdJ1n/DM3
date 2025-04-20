//package com.travel.model;
//
//public class ReservedState implements ReservationState {
//    @Override
//    public void book(Reservation reservation) {
//        System.out.println("Already reserved.");
//    }
//
//    @Override
//    public void pay(Reservation reservation) {
//        reservation.setState(new PaidState());
//        System.out.println("Payment successful. State changed to PAID.");
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
//        System.out.println("Reservation expired.");
//    }
//
//    @Override
//    public void cancel(Reservation reservation) {
//        reservation.setState(new ExpiredState());
//        System.out.println("Reservation cancelled.");
//    }
//}
