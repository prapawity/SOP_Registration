package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Subject;

import java.util.List;

public class SubjectList {
    List<Subject> subjectList;

    public SubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public SubjectList() {
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
