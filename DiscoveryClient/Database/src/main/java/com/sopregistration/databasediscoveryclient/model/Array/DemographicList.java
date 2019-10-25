package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Demographic;

import java.util.List;

public class DemographicList {
    List<Demographic> demographicList;

    public DemographicList(List<Demographic> demographicList) {
        this.demographicList = demographicList;
    }

    public DemographicList() {
    }

    public List<Demographic> getDemographicList() {
        return demographicList;
    }

    public void setDemographicList(List<Demographic> demographicList) {
        this.demographicList = demographicList;
    }
}
