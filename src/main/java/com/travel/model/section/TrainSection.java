package com.travel.model.section;

import com.travel.model.seat.FlightSeat;
import com.travel.model.seat.TrainSeat;

import java.util.ArrayList;
import java.util.List;

/**
 * A section of seats on a train, typically representing a class of service or car type (e.g., First Class, Sleeper).
 */
public class TrainSection extends Section {
    private List<TrainSeat> seats;

    /**
     * Constructs a TrainSection with a given class name, seat capacity, and base price.
     * Automatically creates the specified number of TrainSeat objects.
     * @param name the section name or class (e.g., "First Class", "Coach")
     */
    public TrainSection(String name, int carriages,int rows, Classe classe) {

        super(name, rows*carriages*3, classe);
        if (classe.getId()!='P'&&classe.getId()!='E')
            throw new IllegalArgumentException("Invalid classe");
        if (rows<1||rows>100)
            throw new IllegalArgumentException("Invalid rows");
        if (carriages<1||carriages>30)
            throw new IllegalArgumentException("Invalid carriages");
        int capacity=rows*carriages*3;
        String COLUMN_LETTERS = "ABC";

        this.seats = new ArrayList<>(capacity);
        for(int k=1;k<=carriages;k++){
            for (int i = 1; i <= 3; i++) {
                char col=COLUMN_LETTERS.charAt(i - 1);
                for(int j=1;j<=rows;j++){
                    TrainSeat seat=new TrainSeat(col,j,k);
                    this.seats.add(seat);
                }
            }
        }
    }

    @Override
    public int getAvailableCount() {
        int count = 0;
        for (TrainSeat seat : seats) {
            if (seat.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean book(String id) {
        for (TrainSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.book();
            }
        }
        return false;
    }

    @Override
    public boolean pay(String id) {
        for (TrainSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.pay();
            }
        }
        return false;
    }

    @Override
    public boolean cancel(String id) {
        for (TrainSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.cancel();
            }
        }
        return false;
    }

    @Override
    public boolean lock(String id) {
        for (TrainSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.lock();
            }
        }
        return false;
    }

    @Override
    public boolean unlock(String id) {
        for (TrainSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.unlock();
            }
        }
        return false;
    }

    /** @return list of seats in this section */
    public List<TrainSeat> getTrainSeats() {
        return List.copyOf(seats);
    }
}
