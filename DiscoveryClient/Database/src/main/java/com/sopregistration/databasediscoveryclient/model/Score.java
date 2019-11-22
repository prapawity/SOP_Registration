package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Student.class)
    private Student student;

    @ManyToOne(targetEntity = Subject.class)
    private Subject subject;

    @Column(name = "point")
    @OneToMany(targetEntity = PointsTable.class,mappedBy = "score", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PointsTable> pointsTable;


//    Constructor
    public Score(){

    }

    public Score(Student student, Subject subject, Set<PointsTable> pointsTable) {
        this.student = student;
        this.subject = subject;
        this.pointsTable = pointsTable;
    }

    public Score(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
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

    public Set<PointsTable> getPointsTable() {
        return pointsTable;
    }

    public void setPointsTable(Set<PointsTable> pointsTable) {
        this.pointsTable = pointsTable;
    }
}
