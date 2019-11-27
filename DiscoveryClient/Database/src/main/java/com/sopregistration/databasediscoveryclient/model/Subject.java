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
    @ElementCollection(targetClass=Subject_Teacher.class)
    public List<Subject_Teacher> teacherList;

    @Column(name = "sectionList")
    @ElementCollection(targetClass=Section.class)
    public List<Section> sectionList;

    @OneToOne(targetEntity = Demographic.class)
    public Demographic demographic;

    //constructor
    public Subject(){

    }

    public Subject(int id, List<Subject_Teacher> teacherList, List<Section> sectionList, Demographic demographic) {
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

    public List<Subject_Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Subject_Teacher> teacherList) {
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
