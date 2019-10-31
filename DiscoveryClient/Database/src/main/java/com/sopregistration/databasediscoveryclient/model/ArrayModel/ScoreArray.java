package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Score;

import java.util.List;

public class ScoreArray {
    private List<Score> scoreList;

    public ScoreArray(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public ScoreArray() {
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
