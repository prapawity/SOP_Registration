package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Teacher;

import java.util.List;

public class TeacherArray {
    private List<Teacher> teacherList;

    // constructor

    public TeacherArray() {
    }

    public TeacherArray(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    //getter setter

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
