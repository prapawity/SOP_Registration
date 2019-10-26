package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.SectionCheckStudent;
import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SectionCheckRepository sectionCheck;

    @Autowired
    SubjectRepository subjectRepository;

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

        for (SectionCheckStudent s:sectionCheck.findAll()
             ) {
            if(s.getSection().getId() == id){
                sectionCheck.delete(s);
            }
        }
        List<Section> list = new ArrayList<>();
        for (Subject s: subjectRepository.findAll()
             ) {
            list.clear();
            for (Section sec:s.getSectionList()
                 ) {
                if(sec.getId()!=id){
                    list.add(sec);
                }
            }
            s.setSectionList(list);
            subjectRepository.save(s);
        }

        try {
            sectionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
