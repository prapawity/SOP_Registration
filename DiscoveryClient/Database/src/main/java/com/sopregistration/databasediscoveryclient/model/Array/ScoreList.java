package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Score;

import java.util.List;

public class ScoreList {
    List<Score> scoreList;

    public ScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
    public ScoreList(){

    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
