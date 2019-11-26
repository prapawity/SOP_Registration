package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SectionCheckArray;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.SectionChecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionCheckService {
    @Autowired
    private SectionCheckRepository sectionCheckRepository;
    @Autowired
    private SectionRepository sectionRepository;

    public Boolean createSectionCheck(SectionChecked sectionChecked){
        SectionChecked sectionChecked1 = sectionCheckRepository.save(sectionChecked);
        return sectionChecked1!=null?true:false;
    }

    public Boolean update(SectionChecked sectionChecked, int id){
        SectionChecked oldOne = sectionCheckRepository.findById(id).get();
        oldOne.setSection(sectionChecked.getSection());
        oldOne.setDateTime(sectionChecked.getDateTime());
        oldOne.setStatus(sectionChecked.getStatus());
        oldOne.setStudent(sectionChecked.getStudent());
        SectionChecked sectionChecked1 = sectionCheckRepository.save(oldOne);
        return sectionChecked1!=null?true:false;
    }

    public SectionChecked getSectionCheckByID(int id){
        return sectionCheckRepository.findById(id).get();
    }

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
