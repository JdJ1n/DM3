package com.travel.model.seat;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("trainSeat")
public class TrainSeat extends IndividualSeat {
    private char col;
    private int row;
    private int carriage;

    public TrainSeat() {}

    public TrainSeat(char col, int row, int carriage) {
        if (col < 'A' || col > 'Z') throw new IllegalArgumentException("Invalid column");
        if (row < 1 || row > 100) throw new IllegalArgumentException("Invalid row");
        this.col = col;
        this.row = row;
        this.carriage = carriage;
    }

    public int getCarriage() {
        return carriage;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
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

    // Getters and setters
}
