package com.sopregistation.servicecrud.model.Array;

import com.sopregistation.servicecrud.model.PointsTable;

import java.util.List;

public class PointList {
    private List<PointsTable> pointsTableList;

    public PointList(List<PointsTable> pointsTableList) {
        this.pointsTableList = pointsTableList;
    }
    public PointList(){}

    public List<PointsTable> getPointsTableList() {
        return pointsTableList;
    }

    public void setPointsTableList(List<PointsTable> pointsTableList) {
        this.pointsTableList = pointsTableList;
    }
}
