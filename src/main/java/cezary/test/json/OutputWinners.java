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

    public double getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return "Start date: " + this.date + "\n" +
                this.firstTeamName + " (" + this.countryFirstTeam + ")" +
                " vs " + this.secondTeamName + " (" + this.countrySecondTeam + ")" + "\n" +
                "Venue: " + this.venue + "\n" +
                "Highest probable result : " + this.qualifier.toUpperCase() + " " + result;
    }
}
