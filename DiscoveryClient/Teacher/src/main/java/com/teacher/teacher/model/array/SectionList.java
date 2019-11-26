package com.teacher.teacher.model.array;

import com.teacher.teacher.model.Section;

import java.util.List;

public class SectionList {
    private List<Section> sectionList;

    // constructor


    public SectionList() {
    }

    public SectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    // getter setter

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
