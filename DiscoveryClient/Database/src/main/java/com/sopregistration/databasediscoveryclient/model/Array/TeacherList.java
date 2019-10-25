package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Teacher;

import java.util.List;

public class TeacherList {
    List<Teacher> teacherList;

    public TeacherList(){

    }

    public TeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
