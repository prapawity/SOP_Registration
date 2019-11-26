package com.teacher.teacher.model.array;

import com.teacher.teacher.model.SectionChecked;

import java.util.List;

public class SectionCheckArray {
    private List<SectionChecked> checkedList;

    public SectionCheckArray(List<SectionChecked> checkedList) {
        this.checkedList = checkedList;
    }

    public SectionCheckArray() {
    }

    public List<SectionChecked> getCheckedList() {
        return checkedList;
    }

    public void setCheckedList(List<SectionChecked> checkedList) {
        this.checkedList = checkedList;
    }
}

