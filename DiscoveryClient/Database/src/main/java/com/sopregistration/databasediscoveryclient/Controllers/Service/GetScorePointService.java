package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.PointTableRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.PointArray;
import com.sopregistration.databasediscoveryclient.model.PointsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetScorePointService {
    @Autowired
    private PointTableRepository pointTableRepository;

    public Boolean createPoint(PointsTable point){
        PointsTable pointsTable = pointTableRepository.save(point);
        return pointsTable!=null?true:false;
    }

    public PointArray getAllPoint(){
        PointArray pointArray = new PointArray(pointTableRepository.findAll());
        return pointArray;
    }

    public PointsTable getPointByID(int id){ return pointTableRepository.findById(id).get(); }
}
