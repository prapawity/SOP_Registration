package com.teacher.teacher.model;

public class Scores {
    private int id;
    private Student student;
    private Subject subject;
    private double points;
    private int scoreslot;

    public Scores(){}

    public Scores(Student student, Subject subject, double points, int scoreslot) {
        this.student = student;
        this.subject = subject;
        this.points = points;
        this.scoreslot = scoreslot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getScoreslot() { return scoreslot; }

    public void setScoreslot(int scoreslot) {
        this.scoreslot = scoreslot;
    }
}

