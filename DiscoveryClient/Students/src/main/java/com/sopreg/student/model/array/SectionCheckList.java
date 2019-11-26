package com.sopreg.student.model.array;

import com.sopreg.student.model.SectionChecked;

import java.util.List;

public class SectionCheckList {
    private List<SectionChecked> checkedList;

    public SectionCheckList(List<SectionChecked> checkedList) {
        this.checkedList = checkedList;
    }

    public SectionCheckList() {}

    public List<SectionChecked> getCheckedList() {
        return checkedList;
    }

    public void setCheckedList(List<SectionChecked> checkedList) {
        this.checkedList = checkedList;
    }
}
