package cezary.test.json;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class Events extends JsonParser {

    String sportEventId;
    String startDate;
    String sportName;
    String competitionName;
    String competitionId;
    String seasonName;
    JsonObject venue;
    JsonArray competitors;
    double probabilityHomeTeamWinner;
    double probabilityDraw;
    double probabilityAwayTeamWinner;

    public Events(String sportEventId, String startDate, String sportName, String competitionName,
                  String competitionId, String seasonName, JsonObject venue, JsonArray competitors,
                  double probabilityHomeTeamWinner, double probabilityDraw, double probabilityAwayTeamWinner) {
        this.sportEventId = sportEventId;
        this.startDate = startDate;
        this.sportName = sportName;
        this.competitionName = competitionName;
        this.competitionId = competitionId;
        this.seasonName = seasonName;
        this.venue = venue;
        this.competitors = competitors;
        this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
        this.probabilityDraw = probabilityDraw;
        this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
    }

    @Override
    public String toString() {
        return this.seasonName;
    }
}
