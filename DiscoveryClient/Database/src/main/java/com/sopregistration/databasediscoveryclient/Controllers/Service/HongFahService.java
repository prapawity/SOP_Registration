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

    // define variables

    public boolean createHongfah(HongFah hongFah){
        HongFah saved = hongFahRepository.save(hongFah);
        return saved != null ? true: false;
        //case if want chk result
    }

    //create Hongfah

    public HongFah getHongfah(int id){
        for (HongFah s: hongFahRepository.findAll()
        ) {
            if (id == s.getId()) return s;
        }
        return null;
    }

    // get HongfahbyID

    public List<HongFah> getAllHongfah(){ return hongFahRepository.findAll(); }

    // getAllHongfah

    public Boolean deleteHongfah(int id){
        try {
            for (HongFah h: hongFahRepository.findAll()
                 ) {
                if(h.getId() == id) {
                    try {
                        hongFahRepository.delete(h);
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

    // Delete
}


