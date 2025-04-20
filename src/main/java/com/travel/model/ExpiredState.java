//package com.travel.model;
//
//public class ExpiredState implements ReservationState {
//    @Override
//    public void book(Reservation reservation) {
//        System.out.println("Cannot book an expired reservation.");
//    }
//
//    @Override
//    public void pay(Reservation reservation) {
//        System.out.println("Cannot pay for an expired reservation.");
//    }
//
//    @Override
//    public void confirm(Reservation reservation) {
//        System.out.println("Cannot confirm an expired reservation.");
//    }
//
//    @Override
//    public void expire(Reservation reservation) {
//        System.out.println("Already expired.");
//    }
//
//    @Override
//    public void cancel(Reservation reservation) {
//        System.out.println("Already expired.");
//    }
//}
//
