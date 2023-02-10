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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
