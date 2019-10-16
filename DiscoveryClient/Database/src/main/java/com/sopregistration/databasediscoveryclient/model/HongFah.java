package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class HongFah implements Serializable {
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

//    Constructor
}
