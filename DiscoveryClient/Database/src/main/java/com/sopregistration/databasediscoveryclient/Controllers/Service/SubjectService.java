package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.DemographicRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.Demographic;
import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    DemographicService demographicService;

    public boolean createSubject(Subject subject){
        if(demographicService.createDemographic(subject.demographic) == true){
            try {
                subjectRepository.save(subject);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else return  false;
    }
    public Subject getSubjectID(int id){
        for (Subject s:subjectRepository.findAll()
             ) {
            if(s.getId() == id) return s;
        }
        Subject newsun = new Subject();
        return newsun;
    }

    public List<Subject> getAllSubject(){ return subjectRepository.findAll(); }

    public Boolean deleteSubject(Subject subject){
        try {
            subjectRepository.delete(subject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
