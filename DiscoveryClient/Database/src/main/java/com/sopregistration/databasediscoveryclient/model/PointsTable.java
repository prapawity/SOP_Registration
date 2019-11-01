package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "points")
public class PointsTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Score.class )
    @JoinColumn(name="score_id", nullable=false)
    private Set<Score> score;

    private double points;
    private String describtion;

    public PointsTable(){}


    public PointsTable(Set<Score> score, double points, String describtion) {
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

    public Set<Score> getScore() {
        return score;
    }

    public void setScore(Set<Score> score) {
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
