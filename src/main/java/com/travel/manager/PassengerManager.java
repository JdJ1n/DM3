// com/travel/manager/PassengerManager.java
package com.travel.manager;

import com.travel.model.passenger.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassengerManager implements EntityManager<Passenger> {
    private static final PassengerManager INSTANCE = new PassengerManager();
    private final List<Passenger> items = new ArrayList<>();

    private PassengerManager() {}
    public static PassengerManager getInstance() { return INSTANCE; }

    @Override
    public void add(Passenger p) {
        items.add(p);
    }

    @Override
    public void edit(Passenger p) {
        // TODO
    }

    @Override
    public void delete(Passenger p) {
        items.remove(p);
    }

    @Override
    public List<Passenger> getAll() {
        return Collections.unmodifiableList(items);
    }
}
