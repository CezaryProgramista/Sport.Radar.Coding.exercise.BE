package cezary.test.json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JsonParser {

    static ArrayList<Venue> venueArrayList = new ArrayList<>();
    static int indexOfList = 0;
    static HashMap<Integer, ArrayList<Competitor>> hashMapCompetitor = new HashMap<>();
    static int indexOfHashMapCompetitor = 0;


    public static String json(String file) throws IOException {
        StringBuilder jsonText = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonText.append(line).append("\n");
        }
        bufferedReader.close();
        return jsonText.toString();
    }

    public static ArrayList<Events> parseToObject() throws IOException {
        ArrayList<Events> listOfEvents = new ArrayList<>();
        String strJason = JsonParser.json("C:\\Users\\Cezary\\Downloads\\BE_data.json");
        JsonReader jsonReader = Json.createReader(new StringReader(strJason));
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray jsonArray = jsonObject.getJsonArray("Events");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject singleEvent = jsonArray.getJsonObject(i);
            String sportEventId = singleEvent.getString("sport_event_id");
            String startDate = singleEvent.getString("start_date");
            String sportName = singleEvent.getString("sport_name");
            String competitionName = singleEvent.getString("competition_name");
            String competitionId = singleEvent.getString("competition_id");
            String seasonName = singleEvent.getString("season_name");
            JsonObject venue;
            boolean testing = singleEvent.isNull("venue");
            if (!testing) {
                venue = singleEvent.getJsonObject("venue");
            } else {
                venue = null;
            }
            JsonArray competitors = singleEvent.getJsonArray("competitors");
            double probabilityHomeTeamWinner = Double.parseDouble(String.valueOf(singleEvent.getJsonNumber("probability_home_team_winner")));
            double probabilityDraw = Double.parseDouble(String.valueOf(singleEvent.getJsonNumber("probability_draw")));
            double probabilityAwayTeamWinner = Double.parseDouble(String.valueOf(singleEvent.getJsonNumber("probability_away_team_winner")));
            Events event = new Events(sportEventId, startDate, sportName, competitionName, competitionId, seasonName, venue, competitors,
                    probabilityHomeTeamWinner, probabilityDraw, probabilityAwayTeamWinner);

            listOfEvents.add(i, event);

        }

        return listOfEvents;
    }

    public static ArrayList<Venue> parseToObjectVenue(JsonObject venue) throws IOException {
        try {
            String id = venue.getString("id");
            String name = venue.getString("name");
            int capacity = venue.getInt("capacity");
            String cityName = venue.getString("city_name");
            String countryName = venue.getString("country_name");
            String mapCoordinates = venue.getString("map_coordinates");
            String countryCode = venue.getString("country_code");
            Venue singleVenue = new Venue(id, name, capacity, cityName, countryName, mapCoordinates, countryCode);
            venueArrayList.add(indexOfList, singleVenue);
        } catch (NullPointerException e) {
            Venue singleVenue = new Venue();
            venueArrayList.add(indexOfList, singleVenue);
        }

        indexOfList++;
        if (venueArrayList.size() == parseToObject().size()) {
            return venueArrayList;
        } else {
            return null;
        }
    }

    public static HashMap<Integer, ArrayList<Competitor>> parseToObjectCompetitor(JsonArray competitors) throws IOException {
        ArrayList<Competitor> list = new ArrayList<>();
        int indexOfListCompetitor = 0;
        for (int i = 0; i < competitors.size(); i++) {
            JsonObject object = competitors.getJsonObject(i);
            String id = object.getString("id");
            String name = object.getString("name");
            String country = object.getString("country");
            String countryCode = object.getString("country_code");
            String abbreviation = object.getString("abbreviation");
            String qualifier = object.getString("qualifier");
            String gender = object.getString("gender");
            Competitor competitor = new Competitor(id, name, country, countryCode, abbreviation, qualifier, gender);

            list.add(indexOfListCompetitor, competitor);
            indexOfListCompetitor++;
        }
        hashMapCompetitor.put(indexOfHashMapCompetitor, list);
        indexOfHashMapCompetitor++;
        if (hashMapCompetitor.size() == parseToObject().size()) {

            return hashMapCompetitor;
        } else {
            return null;
        }
    }
}

