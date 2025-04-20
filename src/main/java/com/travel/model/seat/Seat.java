package com.travel.model.seat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "seatType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FlightSeat.class, name = "flightSeat"),
        @JsonSubTypes.Type(value = TrainSeat.class,  name = "trainSeat"),
        @JsonSubTypes.Type(value = CruiseCabin.class,name = "cruiseCabin")
})
public abstract class Seat {
    protected SeatState state = new AvailableState();

    public void book() {
        state.book(this);
    }

    public void pay() {
        state.pay(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    void setState(SeatState state) {
        this.state = state;
    }

    @JsonIgnore
    public SeatState getState() {
        return state;
    }
}
