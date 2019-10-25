package com.sopregistration.databasediscoveryclient.model.Array;

import com.sopregistration.databasediscoveryclient.model.Section;

import java.util.List;

public class SectionList {
    List<Section> sectionLists;


    public SectionList(List<Section> sectionLists) {
        this.sectionLists = sectionLists;
    }

    public SectionList() {
    }

    public List<Section> getSectionLists() {
        return sectionLists;
    }

    public void setSectionLists(List<Section> sectionLists) {
        this.sectionLists = sectionLists;
    }
}
