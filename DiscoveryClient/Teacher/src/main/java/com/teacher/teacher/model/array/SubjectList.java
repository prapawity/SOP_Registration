package com.teacher.teacher.model.array;

import com.teacher.teacher.model.Subject;

import java.util.List;

public class SubjectList {
    private List<Subject> subjectList;

    // constructor

    public SubjectList() {
    }

    public SubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    //getter setter

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
