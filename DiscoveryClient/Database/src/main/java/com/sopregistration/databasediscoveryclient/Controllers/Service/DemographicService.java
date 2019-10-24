package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.DemographicRepository;
import com.sopregistration.databasediscoveryclient.model.Demographic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemographicService {
    @Autowired
    DemographicRepository demographicRepository;

    // define variables

    public boolean createDemographic(Demographic demographic){
        try {
            demographicRepository.save(demographic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // create Demographic

    public Demographic getDemoID(String id){
        for (Demographic d:demographicRepository.findAll()
             ) {
            if(d.getId() == id) return  d;
        }
        return null;
    }

    // get DemobyID

    public List<Demographic> getAllDemographic(){return demographicRepository.findAll();}

    // get All Demo

    public boolean deleteDemographic(String id){
        try {
            for (Demographic d:demographicRepository.findAll()
                 ) {
                if(d.getId() == id) {
                    try {
                        demographicRepository.delete(d);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //delete Demo

}
