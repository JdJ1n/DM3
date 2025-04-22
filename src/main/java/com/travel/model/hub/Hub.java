package com.travel.model.hub;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Airport.class, name = "airport"),
        @JsonSubTypes.Type(value = Port.class, name = "port"),
        @JsonSubTypes.Type(value = Station.class, name = "station")
})
public abstract class Hub {
    private String code;
    private String city;
    private static final Set<String> usedCodes = new HashSet<>();

    public Hub(String code) {
        validateCode(code);
        this.code = code;
        usedCodes.add(code);
        this.city = city;
    }

    protected Hub() {
    }

    private void validateCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Hub code cannot be null or empty.");
        }
        if (code.length() != 3) {
            throw new IllegalArgumentException("Hub code must be 3 digit.");
        }
        if (usedCodes.contains(code)) {
            throw new IllegalArgumentException("Hub code \"" + code + "\" must be unique.");
        }
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCode(String code) {
        validateCode(code);
        usedCodes.remove(this.code);
        this.code = code;
        usedCodes.add(code);
    }

    @Override
    public String toString() {
        return "Hub{" +
                "city='" + city + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hub hub)) return false;
        return Objects.equals(code, hub.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
