package com.sopreg.student.model;

import java.sql.Timestamp;

public class SectionChecked {
    private int id;
    private Student student;
    private Boolean status;
    private Timestamp dateTime;

    public SectionChecked(Student student, Timestamp dateTime, Boolean status) {
        this.student = student;
        this.dateTime = dateTime;
        this.status = status;
    }

    public SectionChecked() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Boolean getStatus() { return status; }

    public void setStatus(Boolean status) { this.status = status; }

    public Timestamp getDateTime() { return dateTime; }

    public void setDateTime(Timestamp dateTime) { this.dateTime = dateTime; }
}
