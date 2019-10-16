package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.ScoreRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.StudentRepository;
import com.sopregistration.databasediscoveryclient.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    public ScoreRepository scoreRepository;

    public void createScore(Score score){
        scoreRepository.save(score);
    }

    public List<Score> getAllScore(){
        return scoreRepository.findAll();
    }
}
