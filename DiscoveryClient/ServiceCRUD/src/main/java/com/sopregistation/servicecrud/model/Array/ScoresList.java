package com.sopregistation.servicecrud.model.Array;

import com.sopregistation.servicecrud.model.Scores;

import java.util.List;

public class ScoresList {
    private List<Scores> scoresList;

    public ScoresList(List<Scores> scoreList) {
        this.scoresList = scoreList;
    }

    public ScoresList() {}

    public List<Scores> getScoresList() {
        return scoresList;
    }

    public void setScoresList(List<Scores> scoresList) {
        this.scoresList = scoresList;
    }
}
