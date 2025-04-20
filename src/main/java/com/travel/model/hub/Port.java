package com.travel.model.hub;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("port")
public class Port extends Hub {
    public Port() {
        super();
    }

    public Port(String code) {
        super(code);
    }
}