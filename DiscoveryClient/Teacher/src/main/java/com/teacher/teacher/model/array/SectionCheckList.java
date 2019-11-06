package com.teacher.teacher.model.array;

import com.teacher.teacher.model.SectionCheck;

import java.util.List;

public class SectionCheckList {
    private List<SectionCheck> checkedList;

    public SectionCheckList(List<SectionCheck> checkedList) {
        this.checkedList = checkedList;
    }

    public SectionCheckList() {}

    public List<SectionCheck> getCheckedList() {
        return checkedList;
    }

    public void setCheckedList(List<SectionCheck> checkedList) {
        this.checkedList = checkedList;
    }
}
