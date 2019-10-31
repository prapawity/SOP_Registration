package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.HongFah;

import java.util.List;

public class HongfahArray {
    private List<HongFah> hongFahList;

    // constructor

    public HongfahArray() {
    }

    public HongfahArray(List<HongFah> hongFahList) {
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
