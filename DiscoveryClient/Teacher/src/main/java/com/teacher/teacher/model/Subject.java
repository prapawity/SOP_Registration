package com.teacher.teacher.model;


import java.util.List;

public class Subject {
    public int id;
    public List<Subject_Teacher> teacherList;
    public List<Section> sectionList;
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