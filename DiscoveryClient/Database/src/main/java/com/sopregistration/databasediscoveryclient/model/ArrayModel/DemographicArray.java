package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Demographic;
import com.sopregistration.databasediscoveryclient.model.HongFah;

import java.util.List;

public class DemographicArray {
    private List<Demographic> demographicList;

    // constructor

    public DemographicArray() {
    }

    public DemographicArray(List<Demographic> demographicList) {
        this.demographicList = demographicList;
    }

    //getter setter

    public List<Demographic> getDemographicList() {
        return demographicList;
    }

    public void setDemographicList(List<Demographic> demographicList) {
        this.demographicList = demographicList;
    }
}
