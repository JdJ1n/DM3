// src/main/java/com/travel/Main.java
package com.travel;

import com.travel.observer.SystemModel;
import com.travel.util.DataInitializer;
import com.travel.model.hub.Hub;
import com.travel.model.company.Company;
import com.travel.model.vehicle.Vehicle;
import com.travel.model.passenger.Passenger;
import com.travel.model.journey.Journey;
import com.travel.model.reservation.Reservation;

public class Main {
    public static void main(String[] args) {
        SystemModel model = SystemModel.getInstance();
        DataInitializer.initialize(model);

        System.out.println("=== Hubs ===");
        for (Hub h : model.getHubs()) {
            System.out.println(" • " + h);
        }

        System.out.println("\n=== Companies ===");
        for (Company c : model.getCompanies()) {
            System.out.println(" • " + c);
        }

        System.out.println("\n=== Vehicles ===");
        for (Vehicle v : model.getVehicles()) {
            System.out.println(" • " + v);
        }

        System.out.println("\n=== Passengers ===");
        for (Passenger p : model.getPassengers()) {
            System.out.println(" • " + p);
        }

        System.out.println("\n=== Journeys ===");
        for (Journey j : model.getJourneys()) {
            System.out.printf(" • "+j);
        }

        System.out.println("\n=== Reservations ===");
        for (Reservation r : model.getReservations()) {
            System.out.printf(" • "+r);
        }
    }
}
