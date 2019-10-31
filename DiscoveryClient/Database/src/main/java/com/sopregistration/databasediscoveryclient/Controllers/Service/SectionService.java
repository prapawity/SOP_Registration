package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SectionArray;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.SectionChecked;
import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SectionCheckRepository sectionCheckRepository;

    public Boolean createSection(Section section){
        Section section1 = sectionRepository.save(section);
        return section1 != null ? true:false;
    }

    public Section getSectionByID(String id){return sectionRepository.findById(id).get();}

    public SectionArray getAllSection(){
        SectionArray sectionArray = new SectionArray(sectionRepository.findAll());
        return sectionArray;
    }

    public Boolean deleteSectionByID(String id){
        List<Section> list;
        for (Subject s:subjectRepository.findAll()
             ) {

            if(s.getSectionList().contains(sectionRepository.findById(id).get())){
                list = new ArrayList<>();
                for (Section sec:s.getSectionList()
                     ) {
                    if(sec.getId() != id)list.add(sec);
                }
                s.setSectionList(list);
                subjectRepository.save(s);
            }
        }
        for (SectionChecked sec:sectionCheckRepository.findAll()
             ) {
            if(sec.getSection().getId()==id)sectionCheckRepository.delete(sec);
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
