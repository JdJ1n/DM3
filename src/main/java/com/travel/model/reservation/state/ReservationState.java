// com/travel/model/reservation/state/ReservationState.java
package com.travel.model.reservation.state;

import com.travel.model.reservation.Reservation;

public interface ReservationState {
    void book(Reservation r);
    void pay(Reservation r);
    void cancel(Reservation r);
    String name();
}
