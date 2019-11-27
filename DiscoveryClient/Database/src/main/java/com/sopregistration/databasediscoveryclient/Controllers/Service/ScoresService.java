package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.ScoresRepository;
import com.sopregistration.databasediscoveryclient.model.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.ScoresArray;


@Service
public class ScoresService {

    @Autowired
    private ScoresRepository scoresRepository;

    public Boolean createScores(Scores scores1){
        Scores scores = scoresRepository.save(scores1);
        return scores!=null?true:false;
    }

    public ScoresArray getAllScores(){
        ScoresArray scoresArray = new ScoresArray(scoresRepository.findAll());
        return scoresArray;
    }

    public Scores getScoresByID(int id){return scoresRepository.findById(id).get();}

    public Boolean deleteScores(int id){
        try {
            scoresRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
