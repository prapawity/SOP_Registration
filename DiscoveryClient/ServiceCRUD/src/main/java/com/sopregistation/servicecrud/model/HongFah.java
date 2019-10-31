package com.sopregistation.servicecrud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class HongFah{

    private String id;

    private String firstName;

    private String lastName;

    //    Constructor
    public HongFah() {
    }

    public HongFah(String id, @NotNull @Size(min = 2, max = 50) String firstName, @NotNull @Size(min = 2, max = 50) String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // getter setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
