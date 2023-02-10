package cezary.test.json;

public class OutputWinners {

    String date;
    String firstTeamName;
    String countryFirstTeam;
    String countrySecondTeam;
    String secondTeamName;
    String venue;
    String qualifier;
    double result;

    public OutputWinners(String date, String firstTeamName, String countryFirstTeam, String secondTeamName, String countrySecondTeam, String venue, String qualifier, double result) {
        this.date = date;
        this.firstTeamName = firstTeamName;
        this.countryFirstTeam = countryFirstTeam;
        this.secondTeamName = secondTeamName;
        this.countrySecondTeam = countrySecondTeam;
        this.venue = venue;
        this.qualifier = qualifier;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getCountryFirstTeam() {
        return countryFirstTeam;
    }

    public void setCountryFirstTeam(String countryFirstTeam) {
        this.countryFirstTeam = countryFirstTeam;
    }

    public String getCountrySecondTeam() {
        return countrySecondTeam;
    }

    public void setCountrySecondTeam(String countrySecondTeam) {
        this.countrySecondTeam = countrySecondTeam;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }



    @Override
    public String toString() {
        return "OutputWinners{" +
                "date='" + date + '\'' +
                ", firstTeamName='" + firstTeamName + '\'' +
                ", countryFirstTeam='" + countryFirstTeam + '\'' +
                ", countrySecondTeam='" + countrySecondTeam + '\'' +
                ", secondTeamName='" + secondTeamName + '\'' +
                ", venue='" + venue + '\'' +
                ", qualifier='" + qualifier + '\'' +
                ", result=" + result +
                '}';
    }
}
