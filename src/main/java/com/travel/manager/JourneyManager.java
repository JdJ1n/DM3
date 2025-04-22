// com/travel/manager/JourneyManager.java
package com.travel.manager;

import com.travel.model.journey.Journey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JourneyManager implements EntityManager<Journey> {
    private static final JourneyManager INSTANCE = new JourneyManager();
    private final List<Journey> items = new ArrayList<>();

    private JourneyManager() {}
    public static JourneyManager getInstance() { return INSTANCE; }

    @Override
    public void add(Journey j) {
        items.add(j);
    }

    @Override
    public void edit(Journey j) { }

    @Override
    public void delete(Journey j) {
        items.remove(j);
    }

    @Override
    public List<Journey> getAll() {
        return Collections.unmodifiableList(items);
    }
}
