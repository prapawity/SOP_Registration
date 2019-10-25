package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.HongFah;

import java.util.List;

public class HongFahList {
    List<HongFah> hongFahList;

    public HongFahList(){

    }

    public HongFahList(List<HongFah> hongFahList) {
        this.hongFahList = hongFahList;
    }

    public List<HongFah> getHongFahList() {
        return hongFahList;
    }

    public void setHongFahList(List<HongFah> hongFahList) {
        this.hongFahList = hongFahList;
    }
}
