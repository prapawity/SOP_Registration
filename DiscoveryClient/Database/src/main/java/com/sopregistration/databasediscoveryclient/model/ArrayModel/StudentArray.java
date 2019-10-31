package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Student;

import java.util.List;

public class StudentArray {
    private List<Student> studentList;

    // constructor
    public StudentArray(){
    }

    public StudentArray(List<Student> studentList) {
        this.studentList = studentList;
    }

    // getter setter
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
