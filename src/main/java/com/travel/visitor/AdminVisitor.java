package com.travel.visitor;

import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;
import com.travel.model.passenger.Passenger;
import javax.swing.JOptionPane;

public class AdminVisitor implements Visitor {
    @Override
    public void visit(Journey journey) {
        JOptionPane.showMessageDialog(null,
                "[Admin] Journey ID: " + journey.getId() +
                        "Departure: " + journey.getDeparture() +"Arrival: " + journey.getArrival());
    }

    @Override
    public void visit(Reservation reservation) {
        JOptionPane.showMessageDialog(null,
                "[Admin] Reservation Ref: " + reservation.getReferenceNumber() +
                        "Status: " + reservation.getStatus());
    }

    @Override
    public void visit(Passenger passenger) {
        JOptionPane.showMessageDialog(null,
                "[Admin] Passenger: " + passenger.getFullName() +
                        "Email: " + passenger.getEmail());
    }
}