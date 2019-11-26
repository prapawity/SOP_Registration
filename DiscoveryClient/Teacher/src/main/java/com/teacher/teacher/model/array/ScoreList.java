package com.teacher.teacher.model.array;

import com.teacher.teacher.model.Score;

import java.util.List;

public class ScoreList {
    private List<Score> scoreList;

    public ScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public ScoreList() {}

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

}
