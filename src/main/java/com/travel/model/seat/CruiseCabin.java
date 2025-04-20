package com.travel.model.seat;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("cruiseCabin")
public class CruiseCabin extends GroupSeat {
    private int capacity;

    public CruiseCabin() {}

    public CruiseCabin(int capacity) {
        if (capacity < 2 || capacity > 6) throw new IllegalArgumentException("Invalid capacity");
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
