package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    public int id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    public String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    public String lastName;

    // constructor

    public Teacher(int id, @NotNull @Size(min = 2, max = 50) String firstName, @NotNull @Size(min = 2, max = 50) String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Teacher(){

    }

    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
