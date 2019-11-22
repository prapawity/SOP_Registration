package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.PointTableRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.ScoreRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.PointArray;
import com.sopregistration.databasediscoveryclient.model.PointsTable;
import com.sopregistration.databasediscoveryclient.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetScorePointService {
    @Autowired
    private PointTableRepository pointTableRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    public Boolean createPoint(PointsTable point){
        List<Score> test = new ArrayList<>();
        for (Score sc:point.getScore()
             ) {
            test.add(scoreRepository.findById(sc.getId()).get());
        }
        if(test.size() == 0){return false;}
        PointsTable p = new PointsTable();
        p.setId(point.getId());
        p.setScore(point.getScore());
        pointTableRepository.save(p);
        PointsTable pointsTable = pointTableRepository.findById(p.getId()).get();
        return pointsTable!=null?true:false;
    }

    public PointArray getAllPoint(){
        PointArray pointArray = new PointArray(pointTableRepository.findAll());
        return pointArray;
    }

    public PointsTable getPointByID(int id){ return pointTableRepository.findById(id).get(); }
}
