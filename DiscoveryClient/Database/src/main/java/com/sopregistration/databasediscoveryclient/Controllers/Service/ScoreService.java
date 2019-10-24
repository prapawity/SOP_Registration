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

    // define variables

    public Boolean createScore(Score score){
        Score score1 = scoreRepository.save(score);
        return score1 != null ? true : false;
    }

    //create Score

    public Score getScoreID(int id){
        for (Score s: scoreRepository.findAll()
             ) {
            if(s.getId() == id) return s;
        }
        return null;
    }

    // get ScoreByID

    public List<Score> getAllScore(){
        return scoreRepository.findAll();
    }

    // get AllScore

    public Boolean deleteScore(int id){
        for (Score s: scoreRepository.findAll()
        ) {
            if(s.getId() == id) {
                try {
                    scoreRepository.delete(s);
                    return true;

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }

            }
        }
        return false;

    }

    // delete Score
}
