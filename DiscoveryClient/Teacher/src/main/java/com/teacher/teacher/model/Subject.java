package com.teacher.teacher.model;

import sun.swing.SwingUtilities2;

import java.util.List;

public class Subject {
    private int id;
    private Demographic demographic;

    public Subject(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) {
        this.demographic = demographic;
    }

}
