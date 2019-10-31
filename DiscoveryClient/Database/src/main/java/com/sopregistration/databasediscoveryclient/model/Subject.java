package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    public int id;

    @Column(name = "teacherList")
    public List<Teacher> teacherList;

    @Column(name = "sectionList")
    public List<Section> sectionList;

    @OneToOne
    public Demographic demographic;

    //constructor
    public Subject(){

    }

    public Subject(int id, List<Teacher> teacherList, List<Section> sectionList, Demographic demographic) {
        this.id = id;
        this.teacherList = teacherList;
        this.sectionList = sectionList;
        this.demographic = demographic;
    }

    //getter setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) {
        this.demographic = demographic;
    }
}
