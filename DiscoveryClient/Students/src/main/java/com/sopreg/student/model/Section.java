package com.sopreg.student.model;


public class Section {
    private String id;

    private String time;

    // constructor
    private Section(){

    }

    public Section(String id, String timet) {
        this.id = id;
        this.time = time;
    }


    //getter setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
