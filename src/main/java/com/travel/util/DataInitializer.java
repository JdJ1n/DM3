// src/main/java/com/travel/util/DataInitializer.java
package com.travel.util;

import com.travel.observer.SystemModel;
import com.travel.model.hub.Airport;
import com.travel.model.hub.Port;
import com.travel.model.hub.Station;
import com.travel.model.company.Airline;
import com.travel.model.company.TrainLine;
import com.travel.model.company.CruiseCompany;
import com.travel.model.passenger.Passenger;
import com.travel.model.reservation.FlightReservation;
import com.travel.model.reservation.TrainReservation;
import com.travel.model.reservation.CruiseReservation;
import com.travel.model.journey.FlightJourney;
import com.travel.model.journey.TrainJourney;
import com.travel.model.journey.CruiseJourney;
import com.travel.model.journey.MultipleJourney;
import com.travel.model.vehicle.Aircraft;
import com.travel.model.vehicle.Train;
import com.travel.model.vehicle.Cruise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class DataInitializer {

    private DataInitializer() { }

    public static void initialize(SystemModel model) {
        // --- Hubs ---
        Airport yul = new Airport("YUL");
        Airport yyz = new Airport("YYZ");
        Port mia   = new Port("MIA");
        Station nyc = new Station("NYC");
        model.addHub(yul);
        model.addHub(yyz);
        model.addHub(mia);
        model.addHub(nyc);

        // --- Companies ---
        Airline airOne   = new Airline("AirOne", "AO");     // code="AirOne", id="AO" (2 chars)
        TrainLine fastRail = new TrainLine("Rail1");        // code="Rail1"
        CruiseCompany seaLines = new CruiseCompany("Cruis"); // code="Cruis" (<=6 chars)
        model.addCompany(airOne);
        model.addCompany(fastRail);
        model.addCompany(seaLines);

        // --- Vehicles ---
        Aircraft boeing737 = new Aircraft(airOne, 737, "Boeing737");
        Train tgv          = new Train(fastRail, "TGV001", "TGV001");
        Cruise carnival    = new Cruise(seaLines, "CARN01", "Carnival");
        model.addVehicle(boeing737);
        model.addVehicle(tgv);
        model.addVehicle(carnival);

        // --- Passengers ---
        Passenger alice = new Passenger(
                "alice@example.com", "Alice", "Anderson",
                "123 Maple St, Montreal", "514-1234",
                "P1234567", LocalDate.of(1985, 5, 10), LocalDate.of(2030, 5, 10)
        );
        Passenger bob = new Passenger(
                "bob@example.com", "Bob", "Brown",
                "456 Oak Ave, Toronto", "416-5678",
                "P2345678", LocalDate.of(1990, 8, 22), LocalDate.of(2028, 8, 22)
        );
        model.addPassenger(alice);
        model.addPassenger(bob);

        // --- Journeys ---
        LocalDateTime now = LocalDateTime.now();
        FlightJourney flight1 = new FlightJourney(
                "J1",
                now.plusDays(1).withHour(9).withMinute(0),
                now.plusDays(1).withHour(12).withMinute(0),
                boeing737,
                yul,
                yyz
        );
        TrainJourney train1 = new TrainJourney(
                "J2",
                now.plusDays(2).withHour(14).withMinute(30),
                now.plusDays(2).withHour(18).withMinute(0),
                tgv,
                List.of(nyc, yyz)
        );
        CruiseJourney cruise1 = new CruiseJourney(
                "J3",
                now.plusDays(5).withHour(16).withMinute(0),
                now.plusDays(10).withHour(8).withMinute(0),
                carnival,
                List.of(mia, yul)
        );
        model.addJourney(flight1);
        model.addJourney(train1);
        model.addJourney(cruise1);

        // --- Reservations ---
        FlightReservation res1 = new FlightReservation("R1", flight1, now, now.plusDays(1));
        TrainReservation res2  = new TrainReservation("R2", train1, now, now.plusHours(12));
        CruiseReservation res3 = new CruiseReservation("R3", cruise1, now, now.plusDays(2));
        model.addReservation(res1);
        model.addReservation(res2);
        model.addReservation(res3);
    }
}
