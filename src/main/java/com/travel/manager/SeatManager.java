// com/travel/manager/SeatManager.java
package com.travel.manager;

import com.travel.model.seat.Seat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatManager implements EntityManager<Seat> {
    private static final SeatManager INSTANCE = new SeatManager();
    private final List<Seat> items = new ArrayList<>();

    private SeatManager() {}
    public static SeatManager getInstance() { return INSTANCE; }

    @Override
    public void add(Seat h) {
        items.add(h);
    }

    @Override
    public void edit(Seat h) { }

    @Override
    public void delete(Seat h) {
        items.remove(h);
    }

    @Override
    public List<Seat> getAll() {
        return Collections.unmodifiableList(items);
    }
}
