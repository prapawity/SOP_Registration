package com.sop.hongfah.model.Array;

import com.sop.hongfah.model.Teacher;

import java.util.List;

public class TeacherList {
    private List<Teacher> teacherList;

    // constructor


    public TeacherList() {
    }

    public TeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    // getter setter


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
