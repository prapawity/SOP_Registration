package com.sopregistation.servicecrud.model;


import java.util.List;

public class Subject{
    private String id;
    private List<Teacher> teacherList;
    private List<Section> sectionList;

    // constructor
    public Subject(String id, List<Teacher> teacherList, List<Section> sectionList) {
        this.id = id;
        this.teacherList = teacherList;
        this.sectionList = sectionList;
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
}
