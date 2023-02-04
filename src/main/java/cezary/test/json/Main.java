package cezary.test.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonParser.parseToObject();
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            JsonParser.parseToObjectVenue(JsonParser.parseToObject().get(i).venue);
            System.out.println(JsonParser.venueArrayList.get(i).toString());
            JsonParser.parseToObjectCompetitor(JsonParser.parseToObject().get(i).competitors);
        }
        typingProbability();
        objectAssociation();
        displayWinners(10);
    }

//    public static List<String> uniqueListOfCompetitors() {
//
//        return JsonParser.hashMapCompetitor.values().stream().
//                map(Competitor ->Competitor.).distinct().sorted().collect(Collectors.toList());
//    }

    public static List<Double> typingProbability() throws IOException {
        List<Double> integerList = new ArrayList<>();
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            HashMap<Integer, Double> doubles = new HashMap<>();
            doubles.put(0, JsonParser.parseToObject().get(i).probabilityHomeTeamWinner);
            doubles.put(1, JsonParser.parseToObject().get(i).probabilityDraw);
            doubles.put(2, JsonParser.parseToObject().get(i).probabilityAwayTeamWinner);
            double max = doubles.values().stream().max(Double::compareTo).get();
            integerList.add(max);

        }
        return integerList;
    }

    public static List<OutputWinners> objectAssociation() throws IOException {
        List<OutputWinners> listOfWinners = new ArrayList<>();
        String q;
        String qualifier;
        String venueName;
        for (int i = 0; i < JsonParser.parseToObject().size(); i++) {
            double max = typingProbability().get(i);


            if (max == JsonParser.parseToObject().get(i).probabilityHomeTeamWinner) {
                q = "HOME";
            } else if (max == JsonParser.parseToObject().get(i).probabilityDraw) {
                q = "DRAW";
            } else {
                q = "AWAY";
            }
            ArrayList<Competitor> c = JsonParser.hashMapCompetitor.get(i);
            if (c.get(0).getQualifier().matches(q)) {
                qualifier = c.get(0).getQualifier();
            } else if (c.get(1).getQualifier().matches(q)) {
                qualifier = c.get(1).getQualifier();

            } else {
                qualifier = "DRAW";
            }
            if (JsonParser.venueArrayList.get(i).name==null) {
                venueName = "Venue Is NULL";
            } else {
                venueName = JsonParser.venueArrayList.get(i).name;
            }
            OutputWinners outputWinners = new OutputWinners(JsonParser.parseToObject().get(i).startDate,
                    c.get(0).getName(), c.get(1).getName(), venueName, qualifier, typingProbability().get(i));
            listOfWinners.add(outputWinners);
        }
        return listOfWinners;
    }

    public static void displayWinners(int teams) throws IOException {
        List<OutputWinners> sortedList = objectAssociation().stream().sorted().toList();
        for (int i = 0; i < teams; i++) {
            System.out.println(sortedList.get(i));

        }
    }
}