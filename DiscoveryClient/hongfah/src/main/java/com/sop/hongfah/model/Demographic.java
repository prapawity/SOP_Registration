package com.sop.hongfah.model;

public class Demographic{

    private String id;
    private String subjectName;
    private String dateTime;
    private Float credit;
    private String subjectDescibe;

    public Demographic(String id, String subjectName, String dateTime, Float credit, String subjectDescibe) {
        this.id = id;
        this.subjectName = subjectName;
        this.dateTime = dateTime;
        this.credit = credit;
        this.subjectDescibe = subjectDescibe;
    }


    public Demographic(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getSubjectDescibe() {
        return subjectDescibe;
    }

    public void setSubjectDescibe(String subjectDescibe) {
        this.subjectDescibe = subjectDescibe;
    }
}
