package com.sopreg.student.model;

import java.sql.Timestamp;

public class SectionCheck {
    private int id;
    private Boolean status;
    private Timestamp dateTime;

    public SectionCheck(Timestamp dateTime, Boolean status) {
        this.dateTime = dateTime;
        this.status = status;
    }

    public SectionCheck() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

}
