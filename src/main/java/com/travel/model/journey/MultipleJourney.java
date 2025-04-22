// MultipleJourney.java
package com.travel.model.journey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.travel.model.vehicle.Vehicle;
import com.travel.model.hub.Hub;

public class MultipleJourney extends Journey {

    private final List<Journey> subJourneys;

    public MultipleJourney(String id,
                           List<Journey> subJourneys,
                           Vehicle vehicle) {
        super(
                id,
                // 整体出发时间：第一个子行程的出发时间
                subJourneys.get(0).getDepartureDateTime(),
                // 整体到达时间：最后一个子行程的到达时间
                subJourneys.get(subJourneys.size() - 1).getArrivalDateTime(),
                vehicle,
                flattenHubs(subJourneys)
        );
        this.subJourneys = new ArrayList<>(subJourneys);
    }

    private static List<Hub> flattenHubs(List<Journey> journeys) {
        List<Hub> hubs = new ArrayList<>();
        for (int i = 0; i < journeys.size(); i++) {
            List<Hub> segmentHubs = journeys.get(i).getHubs();
            if (i == 0) {
                hubs.addAll(segmentHubs);
            } else {
                hubs.addAll(segmentHubs.subList(1, segmentHubs.size()));
            }
        }
        return hubs;
    }

    public List<Journey> getSubJourneys() {
        return Collections.unmodifiableList(subJourneys);
    }
}
