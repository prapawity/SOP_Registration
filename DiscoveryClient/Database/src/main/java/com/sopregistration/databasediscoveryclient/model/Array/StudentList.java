package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Student;

import java.util.List;

public class StudentList {
    List<Student> studentList;

    public StudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentList(){

    }

    // getter setter

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
