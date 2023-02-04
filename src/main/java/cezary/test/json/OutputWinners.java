package cezary.test.json;

public class OutputWinners {

    String date;
    String firstTeamName;
    String secondTeamName;
    String venue;
    String qualifier;
    double result;

    public OutputWinners(String date, String firstTeamName, String secondTeamName, String venue, String qualifier, double result) {
        this.date = date;
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.venue = venue;
        this.qualifier = qualifier;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Start date: " + this.date + "\n" +
                this.firstTeamName + " vs " + this.secondTeamName + "\n" +
                "Highest probable result : " + this.qualifier + " " + result;
    }
}
