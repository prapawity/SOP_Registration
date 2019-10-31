package com.sopregistation.servicecrud.model.Array;

import com.sopregistation.servicecrud.model.HongFah;

import java.util.List;

public class HongfahList {
    private List<HongFah> hongFahList;

    // constructor

    public HongfahList() {
    }

    public HongfahList(List<HongFah> hongFahList) {
        this.hongFahList = hongFahList;
    }

    //getter setter

    public List<HongFah> getHongFahList() {
        return hongFahList;
    }

    public void setHongFahList(List<HongFah> hongFahList) {
        this.hongFahList = hongFahList;
    }
}
