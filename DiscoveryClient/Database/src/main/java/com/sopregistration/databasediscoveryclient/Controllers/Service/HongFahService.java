package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.HongFahRepository;
import com.sopregistration.databasediscoveryclient.model.HongFah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HongFahService {
    @Autowired
    HongFahRepository hongFahRepository;

    public HongFah createStaff(HongFah hongFah){
        return hongFahRepository.save(hongFah);
    }

    public List<HongFah> getAllStaff(){
        return hongFahRepository.findAll();
    }

    public HongFah getStaffByID(int id){
        return hongFahRepository.getOne(id);
    }
}
