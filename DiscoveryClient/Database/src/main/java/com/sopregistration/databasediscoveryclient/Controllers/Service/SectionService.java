package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionRepository;
import com.sopregistration.databasediscoveryclient.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;

    // define variables

    public Boolean createSection(Section section){
        Section section1 = sectionRepository.save(section);
        return section1 != null ? true : false;
    }

    // create Section

    public Section getSectionByID(String id){
        for (Section s: sectionRepository.findAll()
             ) {
            if(s.id == id) return s;
        }
        return  null;
    }

    // get SectionByID

    public List<Section> getAllSection(){ return sectionRepository.findAll();}

    // getAllSection

    public Boolean deleteSection(String id){
        for (Section s: sectionRepository.findAll()
        ) {
            if(s.id == id) {
                try {
                    sectionRepository.delete(s);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }

            }
        }
        return  false;
    }
}
