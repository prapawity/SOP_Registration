package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.model.SectionCheckStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionCheck {
    @Autowired
    SectionCheckRepository sectionCheckRepository;

    // define variables

    public Boolean addSection(SectionCheckStudent sectionCheckStudent){
        SectionCheckStudent sectionCheckStudent1 = sectionCheckRepository.save(sectionCheckStudent);
        return sectionCheckStudent1 != null ? true : false;
    }

    // create SectionCheck

    public SectionCheckStudent getSectionChkByID(int id){
        for (SectionCheckStudent s: sectionCheckRepository.findAll()
             ) {
            if(s.getId() == id) return s;
        }
        return null;
    }

    // getByID SectionCheck

    public List<SectionCheckStudent> getAllSectionCheck(){ return sectionCheckRepository.findAll();}

    // getAll SectionCheck

    public Boolean DeleteSectionCheck(int id){
        for (SectionCheckStudent s: sectionCheckRepository.findAll()
        ) {
            if(s.getId() == id) {
                try {
                    sectionCheckRepository.delete(s);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    // delete SectionCheck
}
