package com.travel.model.seat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.travel.model.seat.state.*;

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

    public boolean book() {
        state.book(this);
        return true;
    }

    public boolean pay() {
        state.pay(this);
        return true;
    }

    public boolean cancel() {
        state.cancel(this);
        return true;
    }

    public boolean lock() {
        state.lock(this);
        return true;
    }

    public boolean unlock() {
        state.unlock(this);
        return true;
    }

    void setState(SeatState state) {
        this.state = state;
    }

    public boolean isAvailable() {
        return getState() instanceof AvailableState;
    }

    public boolean isUnavailable() {
        return getState() instanceof UnavailableState;
    }

    public boolean isReserved() {
        return getState() instanceof ReservedState;
    }

    public boolean isConfirmed() {
        return getState() instanceof ConfirmedState;
    }

    @JsonIgnore
    public SeatState getState() {
        return state;
    }
}
