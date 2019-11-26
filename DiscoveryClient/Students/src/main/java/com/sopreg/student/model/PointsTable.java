package com.sopreg.student.model;

import java.util.List;
import java.util.Set;
public class PointsTable {
    private int id;
    private List<Score> score;
    private double points;
    private String describtion;

    public PointsTable(){}

    public PointsTable(List<Score> score, double points, String describtion) {
        this.score = score;
        this.points = points;
        this.describtion = describtion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {

        this.score = score;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
}
