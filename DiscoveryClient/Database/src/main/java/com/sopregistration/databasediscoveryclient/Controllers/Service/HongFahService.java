package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.HongFahRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.HongfahArray;
import com.sopregistration.databasediscoveryclient.model.HongFah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HongfahService {
    @Autowired
    private HongFahRepository hongFahRepository;

    public Boolean createHongfah(HongFah hongFah){
        HongFah h = hongFahRepository.save(hongFah);
        return h != null ? true:false;
    }


    public HongFah getHongfahByID(String id){return hongFahRepository.findById(id).get();}

    public HongfahArray getHongfahAll(){
        HongfahArray hongfahArray = new HongfahArray(hongFahRepository.findAll());
        return hongfahArray;
    }

    public Boolean deleteHongfahByID(String id){
        try {
            hongFahRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
