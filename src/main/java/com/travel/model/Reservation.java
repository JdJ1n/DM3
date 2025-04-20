//package com.travel.model;
//
//import java.util.Date;
//
//public class Reservation {
//    protected String referenceNumber;
//    protected ReservationState state;
//    private Date creationDate;
//    private Date expirationDate;
//    private String departAirport;
//    private String arrivalAirport;
//    private Date departDate;
//    private Date arrivalDate;
//    private Journey journey;
//
//
//    public ReservationState getStatus() {
//        return state;
//    }
//
//    public void getPayInfo() {
//        // 实现获取支付信息逻辑
//    }
//
//    public Journey getJourney() {
//        return journey;
//    }
//
//    public Reservation() {
//        this.state = new ReservedState(); // 初始状态为RESERVED
//    }
//
//    public void setState(ReservationState state) {
//        this.state = state;
//    }
//
//    public void book() {
//        state.book(this);
//    }
//
//    public void pay() {
//        state.pay(this);
//    }
//
//    public void confirm() {
//        state.confirm(this);
//    }
//
//    public void expire() {
//        state.expire(this);
//    }
//
//    public void cancel() {
//        state.cancel(this);
//    }
//}
