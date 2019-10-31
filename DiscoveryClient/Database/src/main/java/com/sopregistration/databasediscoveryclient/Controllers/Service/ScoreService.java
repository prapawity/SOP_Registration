package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.ScoreRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.ScoreArray;
import com.sopregistration.databasediscoveryclient.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Boolean createScore(Score score1){
        Score score = scoreRepository.save(score1);
        return score!=null?true:false;
    }

    public ScoreArray getAllScore(){
        ScoreArray scoreArray = new ScoreArray(scoreRepository.findAll());
        return scoreArray;
    }

    public Score getScoreByID(int id){return scoreRepository.findById(id).get();}

    public Boolean deleteScore(int id){
        try {
            scoreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
