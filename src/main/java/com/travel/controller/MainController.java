package com.travel.controller;

import com.travel.observer.SystemModel;
import com.travel.visitor.AdminVisitor;
import com.travel.visitor.ClientVisitor;
import com.travel.visitor.Visitor;
import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;
import com.travel.model.passenger.Passenger;
import com.travel.view.MainView;
import com.travel.view.admin.AdminView;
import com.travel.view.client.ClientView;

public class MainController {
    private Visitor visitor;

    public MainController() {}

    public void handleRoleSelection(MainView roleView, boolean isAdmin) {
        if (isAdmin) {
            AdminView adminView = new AdminView();
            SystemModel.getInstance().attach(adminView);
            visitor = new AdminVisitor();
            adminView.setVisible(true);
        } else {
            ClientView clientView = new ClientView();
            SystemModel.getInstance().attach(clientView);
            visitor = new ClientVisitor();
            clientView.setVisible(true);
        }
    }

    public void browseJourneys() {
        for (Journey j : SystemModel.getInstance().getJourneys()) {
            j.accept(visitor);
        }
    }

    public void browseReservations() {
        for (Reservation r : SystemModel.getInstance().getReservations()) {
            r.accept(visitor);
        }
    }

    public void browsePassengers() {
        for (Passenger p : SystemModel.getInstance().getPassengers()) {
            p.accept(visitor);
        }
    }
}