package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "secchk")
public class SectionCheckStudent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    Section section;

    @ManyToMany
    List<Student> studentList;

    @Column(name = "points")
    Boolean check;

    //constructor
    public SectionCheckStudent(){

    }

    public SectionCheckStudent(Section section, List<Student> student, Boolean check) {
        this.section = section;
        this.studentList = student;
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

    public List<Student> getStudent() {
        return studentList;
    }

    public void setStudent(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}
