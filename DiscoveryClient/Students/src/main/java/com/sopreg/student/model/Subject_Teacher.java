package com.sopreg.student.model;

public class Subject_Teacher {
    private int id;
    private Teacher teacher;

    public Subject_Teacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Subject_Teacher(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
