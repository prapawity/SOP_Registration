package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    public Student student;

    @ManyToOne
    public Subject subject;

    @Column(name = "point")
    public List<Double> point;


//    Constructor
    public Score(){

    }

    public Score(Student student, Subject subject, List<Double> point) {
        this.student = student;
        this.subject = subject;
        this.point = point;
    }
    //    Getter Setter


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

    public List<Double> getPoint() {
        return point;
    }

    public void setPoint(List<Double> point) {
        this.point = point;
    }
}
