package cezary.test.json;

public class Competitor {
    String id;
    String name;
    String country;
    String countryCode;
    String abbreviation;
    String qualifier;
    String gender;


    public Competitor(String id, String name, String country, String countryCode, String abbreviation, String qualifier, String gender) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.abbreviation = abbreviation;
        this.qualifier = qualifier;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getQualifier() {
        return this.qualifier;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
