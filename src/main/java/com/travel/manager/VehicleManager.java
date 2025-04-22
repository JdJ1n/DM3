package com.travel.manager;

import com.travel.model.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleManager implements EntityManager<Vehicle> {
    private static final VehicleManager INSTANCE = new VehicleManager();
    private final List<Vehicle> items = new ArrayList<>();

    private VehicleManager() {}
    public static VehicleManager getInstance() { return INSTANCE; }

    @Override public void add(Vehicle v) { items.add(v); }
    @Override public void edit(Vehicle v) {  }
    @Override public void delete(Vehicle v) { items.remove(v); }
    @Override public List<Vehicle> getAll() { return Collections.unmodifiableList(items); }
}