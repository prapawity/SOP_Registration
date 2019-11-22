package com.sopreg.student.model;

import java.util.List;
import java.util.Set;

public class Score {
    private int id;
    private Student student;
    private Subject subject;
    private List<PointsTable> pointsTable;

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

    public List<PointsTable> getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(List<PointsTable> pointsTable) {
        this.pointsTable = pointsTable;
    }
}
