package com.travel.model.hub;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("airport")
public class Airport extends Hub {
    public Airport() {
        super();
    }

    public Airport(String code) {
        super(code);
    }
}