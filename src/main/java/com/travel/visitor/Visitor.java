package com.travel.visitor;

import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;
import com.travel.model.passenger.Passenger;

public interface Visitor {
    void visit(Journey journey);
    void visit(Reservation reservation);
    void visit(Passenger passenger);
}