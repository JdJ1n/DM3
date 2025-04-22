// com/travel/manager/ReservationManager.java
package com.travel.manager;

import com.travel.model.reservation.Reservation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationManager implements EntityManager<Reservation> {
    private static final ReservationManager INSTANCE = new ReservationManager();
    private final List<Reservation> items = new ArrayList<>();

    private ReservationManager() {}
    public static ReservationManager getInstance() { return INSTANCE; }

    @Override
    public void add(Reservation r) {
        items.add(r);
    }

    @Override
    public void edit(Reservation r) {
        // TODO
    }

    @Override
    public void delete(Reservation r) {
        items.remove(r);
    }

    @Override
    public List<Reservation> getAll() {
        return Collections.unmodifiableList(items);
    }
}
