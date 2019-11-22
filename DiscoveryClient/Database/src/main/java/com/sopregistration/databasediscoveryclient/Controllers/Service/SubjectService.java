package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.DemographicRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SubjectArray;
import com.sopregistration.databasediscoveryclient.model.Demographic;
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
        boolean demoSaved;
        Demographic demoTemp = null;
        try {
            demoTemp = demographicRepository.save(subject.demographic);
            System.out.println(demoTemp);
            demoSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
            demoSaved = false;
        }
        if (demoSaved) {
            subject.demographic = demoTemp;
            Subject saved = subjectRepository.save(subject);
            return saved!=null?true:false;
        } else {
            return false;
        }
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
