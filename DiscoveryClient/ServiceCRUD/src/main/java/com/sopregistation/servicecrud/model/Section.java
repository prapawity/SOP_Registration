package com.sopregistation.servicecrud.model;

import java.io.Serializable;
import java.util.List;


public class Section implements Serializable {
    private String id;

    private String time;

    private List<Student> studentList;

    private int maxStudent;

    // constructor
    private Section(){

    }

    public Section(String id, String time, List<Student> studentList, int maxStudent) {
        this.id = id;
        this.time = time;
        this.studentList = studentList;
        this.maxStudent = maxStudent;
    }


    //getter setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }
}

