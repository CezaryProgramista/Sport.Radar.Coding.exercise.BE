package cezary.test.json;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Lists {

    List<OutputWinners> outputWinnersList;
    List<String> competitorsList;

    public Lists()  {
        this.outputWinnersList = new ArrayList<>();
        this.competitorsList = new ArrayList<>();
    }

    public List<OutputWinners> getOutputWinnersList() {
        return outputWinnersList;
    }

    public List<String> getCompetitorsList() {
        return competitorsList;
    }
}
