package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Scores;

import java.util.List;

public class ScoresArray {
    private List<Scores> scoresList;

    public ScoresArray(List<Scores> scoresList) {
        this.scoresList = scoresList;
    }

    public ScoresArray() {
    }

    public List<Scores> getScoresList() {
        return scoresList;
    }

    public void setScoresList(List<Scores> scoresList) {
        this.scoresList = scoresList;
    }
}
