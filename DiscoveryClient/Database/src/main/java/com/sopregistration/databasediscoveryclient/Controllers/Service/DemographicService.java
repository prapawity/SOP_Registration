package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.DemographicRepository;
import com.sopregistration.databasediscoveryclient.model.Demographic;
import com.sopregistration.databasediscoveryclient.model.PointsTable;
import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemographicService {
    @Autowired
    DemographicRepository demographicRepository;
    public Demographic getDemoID(String id){ return demographicRepository.findById(id).get(); }
    public boolean createDemographic(Demographic demographic){
        try {
            demographicRepository.save(demographic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}