package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.DemographicRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SubjectArray;
import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DemographicRepository demographicRepository;

    public Boolean createSubject(Subject subject){
        Subject saved = subjectRepository.save(subject);
        return saved!=null?true:false;
    }

    public Subject getSubjectByID(int id){ return subjectRepository.findById(id).get(); }

    public SubjectArray getAllSubject(){
        SubjectArray subjectArray = new SubjectArray(subjectRepository.findAll());
        return subjectArray;
    }

    public boolean deleteSubject(int id){
        try {
            subjectRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
