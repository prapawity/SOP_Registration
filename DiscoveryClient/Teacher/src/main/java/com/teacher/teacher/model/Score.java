package com.teacher.teacher.model;

import java.util.Set;

public class Score {
    private int id;
    private Student student;
    private Subject subject;
    private Set<PointsTable> pointsTable;

    public Score(){}

    public Score(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
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

    public Set<PointsTable> getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(Set<PointsTable> pointsTable) {
        this.pointsTable = pointsTable;
    }
}
