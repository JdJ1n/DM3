// com/travel/manager/LocationManager.java
package com.travel.manager;

import com.travel.model.hub.Hub;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HubManager implements EntityManager<Hub> {
    private static final HubManager INSTANCE = new HubManager();
    private final List<Hub> items = new ArrayList<>();

    private HubManager() {}
    public static HubManager getInstance() { return INSTANCE; }

    @Override
    public void add(Hub h) {
        items.add(h);
    }

    @Override
    public void edit(Hub h) { }

    @Override
    public void delete(Hub h) {
        items.remove(h);
    }

    @Override
    public List<Hub> getAll() {
        return Collections.unmodifiableList(items);
    }
}
