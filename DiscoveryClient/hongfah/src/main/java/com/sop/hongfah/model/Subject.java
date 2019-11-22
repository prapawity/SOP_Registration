package com.sop.hongfah.model;

import java.util.List;

public class Subject{
    private String id;
    private List<Teacher> teacherList;
    private List<Section> sectionList;
    private Demographic demographic;

    // constructor
    public Subject(String id, List<Teacher> teacherList, List<Section> sectionList, Demographic demographic) {
        this.id = id;
        this.teacherList = teacherList;
        this.sectionList = sectionList;
        this.demographic = demographic;
    }

    public Subject(){}

    //getter setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
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