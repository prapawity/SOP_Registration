package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.*;
import com.sopregistration.databasediscoveryclient.model.*;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.SubjectArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DemographicRepository demographicRepository;
    @Autowired
    private ScoresRepository scoresRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private Subject_TeacherRepository subject_teacherRepository;

    public Boolean createSubject(Subject subject){
        boolean demoSaved;
        Demographic demoTemp = null;
        try {
            demoTemp = demographicRepository.save(subject.demographic);
            demoSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
            demoSaved = false;
        }
        for (Section sec:subject.getSectionList()
             ) {
            sectionRepository.save(sec);
        }
        for (Subject_Teacher sj:subject.getTeacherList()
             ) {
            subject_teacherRepository.save(sj);
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
        List<Scores> lis = new ArrayList<>();
        for (Scores score:scoresRepository.findAll()
             ) {
            if(score.getSubject().getId() == id){
                lis.add(score);
            }
        }
        for (Scores score:lis
             ) {
            scoresRepository.delete(score);
        }
        try {
            subjectRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
