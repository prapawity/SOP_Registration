package com.sopreg.student.model;

import java.util.List;

public class Subject {
    private String id;
    private Demographic demographic;

    public Subject(){}

    public Subject(String id, Demographic demographic) {
        this.id = id;
        this.demographic = demographic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) { this.demographic = demographic; }

}
