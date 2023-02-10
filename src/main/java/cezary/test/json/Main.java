package cezary.test.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);

        JsonParser.parseToObject();
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            JsonParser.parseToObjectVenue(JsonParser.parseToObject().get(i).venue);
            JsonParser.parseToObjectCompetitor(JsonParser.parseToObject().get(i).competitors);
        }
    }

    public static List<String> uniqueListOfCompetitors() {
        return JsonParser.hashMapCompetitor.values().stream().
                map(Competitor -> Competitor.iterator().next().getName()).distinct().sorted().collect(Collectors.toList());
    }

    public static List<Double> typingProbability() throws IOException {
        List<Double> integerList = new ArrayList<>();
        List<Events> listOfEvents = JsonParser.parseToObject();
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            ArrayList<Double> doubles = new ArrayList<>();
            doubles.add(0, listOfEvents.get(i).probabilityHomeTeamWinner);
            doubles.add(1, listOfEvents.get(i).probabilityDraw);
            doubles.add(2, listOfEvents.get(i).probabilityAwayTeamWinner);
            double max = doubles.stream().max(Double::compareTo).get();
            integerList.add(max);

        }
        return integerList;
    }

    public static List<OutputWinners> objectAssociation() throws IOException {
        List<OutputWinners> listOfWinners = new ArrayList<>();
        List<Double> listOfProbability = typingProbability();
        List<Events> listOfEvents = JsonParser.parseToObject();
        List<Venue> listOfVenues = JsonParser.venueArrayList;
        String q;
        String qualifier;
        String venueName;
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            double max = listOfProbability.get(i);


            if (max == listOfEvents.get(i).probabilityHomeTeamWinner) {
                q = "HOME";
            } else if (max == listOfEvents.get(i).probabilityAwayTeamWinner) {
                q = "AWAY";
            } else {
                q = "DRAW";
            }
            ArrayList<Competitor> c = JsonParser.hashMapCompetitor.get(i);
            if (c.get(0).getQualifier().equalsIgnoreCase(q)) {
                qualifier = c.get(0).getQualifier() + "_TEAM_WIN";
            } else if (c.get(1).getQualifier().equalsIgnoreCase(q)) {
                qualifier = c.get(1).getQualifier() + "_TEAM_WIN";

            } else {
                qualifier = "DRAW";
            }

            if (listOfVenues.get(i).toString().matches("VENUE NOT FOUND")) {
                venueName = "VENUE IS NULL";
            } else {
                venueName = listOfVenues.get(i).name;
            }
            String countryFirstTeam = c.get(0).country;
            String countrySecondTeam = c.get(1).country;
            String date = listOfEvents.get(i).startDate;
            OutputWinners outputWinners = new OutputWinners(date,
                    c.get(0).getName(), countryFirstTeam, c.get(1).getName(), countrySecondTeam, venueName, qualifier, listOfProbability.get(i));
            listOfWinners.add(outputWinners);
        }
        return listOfWinners;
    }

    public static List<OutputWinners> displayWinners(List<OutputWinners> list, int teams) {
        ArrayList<OutputWinners> winners = new ArrayList<>();
        List<OutputWinners> sortedList = list.stream().sorted(Comparator.comparingDouble(OutputWinners::getResult).reversed()).toList();
        for (int i = 0; i < teams; i++) {
            winners.add(sortedList.get(i));
        }
        return winners;
    }
}