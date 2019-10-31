package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.Section;

import java.util.List;

public class SectionArray {
    private List<Section> sectionList;

    // constructor

    public SectionArray(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public SectionArray() {
    }

    // getter setter


    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
