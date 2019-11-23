package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Subject.class )
    @JoinColumn(name="subject_id", nullable=false)
    private Subject subject;

    @ManyToOne(targetEntity = Student.class )
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    private double points;
    private int scoreslot;

    public Scores(int id, Subject subject, Student student, double points, int scoreslot) {
        this.id = id;
        this.subject = subject;
        this.student = student;
        this.points = points;
        this.scoreslot = scoreslot;
    }

    public Scores() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() { return subject; }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() { return student; }

    public void setStudent(Student student) {
        this.student = student;
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
