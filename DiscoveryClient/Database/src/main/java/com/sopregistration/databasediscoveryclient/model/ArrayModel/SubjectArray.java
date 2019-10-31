package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Subject;

import java.util.List;

public class SubjectArray {
    private List<Subject> subjectList;

    // constructor

    public SubjectArray(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public SubjectArray(){}

    // getter setter

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
