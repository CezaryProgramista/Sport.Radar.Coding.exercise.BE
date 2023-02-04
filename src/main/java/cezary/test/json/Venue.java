package cezary.test.json;

import java.util.Objects;

public class Venue {
    String id;
    String name;
    int capacity;
    String cityName;
    String countryName;
    String mapCoordinates;
    String countryCode;

    public Venue() {

    }

    public Venue(String id, String name, int capacity, String cityName, String countryName, String mapCoordinates, String countryCode) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.cityName = cityName;
        this.countryName = countryName;
        this.mapCoordinates = mapCoordinates;
        this.countryCode = countryCode;
    }

    public String toString() {
        return Objects.requireNonNullElse(this.name, "VENUE NOT FOUND");
    }
}
