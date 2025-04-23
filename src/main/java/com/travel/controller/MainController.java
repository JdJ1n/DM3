// src/main/java/com/travel/controller/MainController.java
package com.travel.controller;

import com.travel.manager.*;
import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;
import com.travel.observer.SystemModel;
import com.travel.visitor.AdminVisitor;
import com.travel.visitor.ClientVisitor;
import com.travel.visitor.Visitor;
import com.travel.view.MainView;
import com.travel.view.admin.AdminView;
import com.travel.view.client.ClientView;

import java.util.List;

public class MainController {
    private Visitor visitor;
    private final SystemModel model = SystemModel.getInstance();

    public MainController() { }

    public void handleRoleSelection(MainView roleView, boolean isAdmin) {
        if (isAdmin) {
            AdminView adminView = new AdminView(this);
            model.attach(adminView);
            visitor = new AdminVisitor();
            adminView.setVisible(true);
        } else {
            ClientView clientView = new ClientView(this);
            model.attach(clientView);
            visitor = new ClientVisitor();
            clientView.setVisible(true);
        }
    }

    public List<Journey> getAllJourneys() {
        return model.getJourneys();
    }

    public void removeJourney(Journey j) {
        JourneyManager.getInstance().delete(j);
        model.notifyObservers();
    }

    public void addJourney(Journey j) {
        JourneyManager.getInstance().add(j);
        model.notifyObservers();
    }

    public List<Reservation> getAllReservations() {
        return model.getReservations();
    }

    public void removeReservation(Reservation r) {
        ReservationManager.getInstance().delete(r);
        model.notifyObservers();
    }

    public void addReservation(Reservation r) {
        ReservationManager.getInstance().add(r);
        model.notifyObservers();
    }

    public void browseJourneys() {
        for (Journey j : getAllJourneys()) {
            j.accept(visitor);
        }
    }

    public void browseReservations() {
        for (Reservation r : getAllReservations()) {
            r.accept(visitor);
        }
    }
}
