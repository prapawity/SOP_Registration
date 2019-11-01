package com.sopregistration.databasediscoveryclient.model.ArrayModel;

import com.sopregistration.databasediscoveryclient.model.PointsTable;

import java.util.List;

public class PointArray {
    private List<PointsTable> pointsTableList;

    public PointArray(List<PointsTable> pointsTableList) {
        this.pointsTableList = pointsTableList;
    }
    public PointArray(){}

    public List<PointsTable> getPointsTableList() {
        return pointsTableList;
    }

    public void setPointsTableList(List<PointsTable> pointsTableList) {
        this.pointsTableList = pointsTableList;
    }
}
