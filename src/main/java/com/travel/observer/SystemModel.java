package com.travel.observer;

import com.travel.manager.*;
import com.travel.model.hub.Hub;
import com.travel.model.journey.Journey;
import com.travel.model.company.Company;
import com.travel.model.passenger.Passenger;
import com.travel.model.reservation.Reservation;
import com.travel.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class SystemModel implements Subject {
    private static final SystemModel INSTANCE = new SystemModel();
    private final List<Observer> observers = new ArrayList<>();

    private SystemModel() {}
    public static SystemModel getInstance() { return INSTANCE; }

    @Override public void attach(Observer o)  { observers.add(o); }
    @Override public void detach(Observer o)  { observers.remove(o); }
    @Override public void notifyObservers()   { observers.forEach(o -> o.update(this)); }

    public List<Hub>      getHubs()        { return HubManager.getInstance().getAll(); }
    public List<Journey>  getJourneys()    { return JourneyManager.getInstance().getAll(); }
    public List<Company>  getCompanies()   { return CompanyManager.getInstance().getAll(); }
    public List<Passenger>getPassengers()  { return PassengerManager.getInstance().getAll(); }
    public List<Reservation> getReservations() { return ReservationManager.getInstance().getAll(); }
    public List<Vehicle>  getVehicles()    { return VehicleManager.getInstance().getAll(); }

    public void addHub(Hub h) { HubManager.getInstance().add(h); notifyObservers(); }
    public void addJourney(Journey j) { JourneyManager.getInstance().add(j); notifyObservers(); }
    public void addCompany(Company c) { CompanyManager.getInstance().add(c); notifyObservers(); }
    public void addPassenger(Passenger p) { PassengerManager.getInstance().add(p); notifyObservers(); }
    public void addReservation(Reservation r) { ReservationManager.getInstance().add(r); notifyObservers(); }
    public void addVehicle(Vehicle v) { VehicleManager.getInstance().add(v); notifyObservers(); }}