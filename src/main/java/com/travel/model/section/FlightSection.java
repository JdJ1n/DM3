package com.travel.model.section;

import com.travel.model.seat.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A section of seats on a flight, typically representing a class of service (e.g., Economy, Business).
 */
public class FlightSection extends Section {
    private List<FlightSeat> seats;

    /**
     * Constructs a FlightSection with a given class name, seat capacity, and base price.
     * Automatically creates the specified number of FlightSeat objects (initially all available).
     * @param name the section name or class (e.g., "Economy", "Business")
     * @param classe base price per seat in this section
     */
    public FlightSection(String name, int rows, int cols, Classe classe) {
        super(name, rows*cols, classe);
        if (classe.getId()!='F'&&classe.getId()!='A'&&classe.getId()!='P'&&classe.getId()!='E')
            throw new IllegalArgumentException("Invalid classe");
        if (rows<1||rows>100)
            throw new IllegalArgumentException("Invalid rows");
        if (cols!=3&&cols!=4&&cols!=6&&cols!=10)
            throw new IllegalArgumentException("Invalid colonnes");
        int capacity=cols*rows;
        String COLUMN_LETTERS = "ABCDEFGHIJ";

        this.seats = new ArrayList<>(capacity);
        for (int i = 1; i <= cols; i++) {
            char col=COLUMN_LETTERS.charAt(i - 1);
            for(int j=1;j<=rows;j++){
                FlightSeat seat=new FlightSeat(col,j);
                this.seats.add(seat);
            }
        }
    }

    @Override
    public int getAvailableCount() {
        int count = 0;
        for (FlightSeat seat : seats) {
            if (seat.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean book(String id) {
        for (FlightSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.book();
            }
        }
        return false;
    }

    @Override
    public boolean pay(String id) {
        for (FlightSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.pay();
            }
        }
        return false;
    }

    @Override
    public boolean cancel(String id) {
        for (FlightSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.cancel();
            }
        }
        return false;
    }

    @Override
    public boolean lock(String id) {
        for (FlightSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.lock();
            }
        }
        return false;
    }

    @Override
    public boolean unlock(String id) {
        for (FlightSeat seat : seats) {
            if (seat.getId().equals(id)) {
                return seat.unlock();
            }
        }
        return false;
    }

    /** @return list of seats in this section */
    public List<FlightSeat> getFlightSeats() {
        return List.copyOf(seats);
    }
}
