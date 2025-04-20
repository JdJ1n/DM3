package com.travel.model.hub;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("station")
public class Station extends Hub {
    public Station() {
        super();
    }

    public Station(String code) {
        super(code);
    }
}