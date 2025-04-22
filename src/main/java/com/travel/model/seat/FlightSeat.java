package com.travel.model.seat;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("flightSeat")
public class FlightSeat extends IndividualSeat {
    private char col;
    private int row;

    public FlightSeat() {}

    public FlightSeat(char col, int row) {
        if (col < 'A' || col > 'J') throw new IllegalArgumentException("Invalid column");
        if (row < 1 || row > 100) throw new IllegalArgumentException("Invalid row");
        this.col = col;
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getId() {
        return String.valueOf(col) + row;
    }

}
