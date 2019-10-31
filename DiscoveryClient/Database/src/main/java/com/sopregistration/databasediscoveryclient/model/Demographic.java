package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "demographic")
public class Demographic implements Serializable {
    @Id
    private String id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "exam_schedule")
    private String dateTime;

    @Column(name = "credit")
    private Float credit;

    @Size(min = 2, max = 50)
    @Column(name = "subject_desc")
    private String subjectDescibe;

    // constructor


    public Demographic(String id, @NotNull @Size(min = 2, max = 50) String subjectName, String dateTime, Float credit, @Size(min = 2, max = 50) String subjectDescibe) {
        this.id = id;
        this.subjectName = subjectName;
        this.dateTime = dateTime;
        this.credit = credit;
        this.subjectDescibe = subjectDescibe;
    }

    public Demographic(){

    }


    // getter setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getSubjectDescibe() {
        return subjectDescibe;
    }

    public void setSubjectDescibe(String subjectDescibe) {
        this.subjectDescibe = subjectDescibe;
    }
}
