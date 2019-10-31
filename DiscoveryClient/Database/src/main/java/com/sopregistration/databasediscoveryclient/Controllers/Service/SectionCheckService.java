package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SectionCheckArray;
import com.sopregistration.databasediscoveryclient.model.SectionChecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionCheckService {
    @Autowired
    private SectionCheckRepository sectionCheckRepository;

    public Boolean createSectionCheck(SectionChecked sectionChecked){
        SectionChecked sectionChecked1 = sectionCheckRepository.save(sectionChecked);
        return sectionChecked1!=null?true:false;
    }

    public SectionChecked getSectionByID(int id){return sectionCheckRepository.findById(id).get();}

    public SectionCheckArray getAllSectionCheck(){
        SectionCheckArray sectionCheckArray = new SectionCheckArray(sectionCheckRepository.findAll());
        return sectionCheckArray;
    }

    public Boolean deleteSectionCheck(int id){
        try {
            sectionCheckRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
