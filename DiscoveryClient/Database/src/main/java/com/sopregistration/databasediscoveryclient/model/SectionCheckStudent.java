package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "secchk")
public class SectionCheckStudent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne
    Section section;

    @OneToOne
    Student student;

    @Column(name = "points")
    Boolean check;

    //constructor
    public SectionCheckStudent(){

    }

    public SectionCheckStudent(Section section, Student student, Boolean check) {
        this.section = section;
        this.student = student;
        this.check = check;
    }

    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}
