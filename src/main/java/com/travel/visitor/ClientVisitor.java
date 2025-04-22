package com.travel.visitor;

import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;
import com.travel.model.passenger.Passenger;
import javax.swing.JOptionPane;

public class ClientVisitor implements Visitor {
    @Override
    public void visit(Journey journey) {
        JOptionPane.showMessageDialog(null,
                "[Client] Your journey from " + journey.getDeparture() +
                        " to " + journey.getArrival());
    }

    @Override
    public void visit(Reservation reservation) {
        JOptionPane.showMessageDialog(null,
                "[Client] Your reservation status: " + reservation.getStatus());
    }

    @Override
    public void visit(Passenger passenger) {
        JOptionPane.showMessageDialog(null,
                "[Client] Welcome, " + passenger.getFullName());
    }
}