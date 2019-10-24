package com.sopregistration.databasediscoveryclient.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "demographic")
public class Demographic implements Serializable {
    @Id
    public String id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "subject_name")
    public String subjectName;

    @Column(name = "exam_schedule")
    public String dateTime;

    @Column(name = "credit")
    public Float credit;

    @Size(min = 2, max = 50)
    @Column(name = "subject_desc")
    public String subjectDescibe;

    // constructor



    public Demographic(){

    }

    public Demographic(String id, @NotNull @Size(min = 2, max = 50) String subjectName, String dateTime, Float credit, @Size(min = 2, max = 50) String subjectDescibe) {
        this.id = id;
        this.subjectName = subjectName;
        this.dateTime = dateTime;
        this.credit = credit;
        this.subjectDescibe = subjectDescibe;
    }
    // getter setter


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

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
