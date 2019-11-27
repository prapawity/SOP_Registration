package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.*;
import com.sopregistration.databasediscoveryclient.model.*;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.StudentArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SectionCheckRepository sectionCheckRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private ScoresRepository scoresRepository;

    public Boolean createStudent(Student student){
        Student saved = studentRepository.save(student);
        return saved != null ? true : false;
    }

    public Student getStudentByID(int id){
        return studentRepository.findById(id).get();
    }

    public StudentArray getAllStudent(){
        StudentArray studentArray = new StudentArray(studentRepository.findAll());
        return studentArray;
    }

    public Boolean deleteStudentByID(int id){
        List<Student> list;
        List<Section> list1;
        for (Subject s:subjectRepository.findAll()
             ) {
            list1 = new ArrayList<>();
            for (Section sec:s.getSectionList()
                 ) {
                if(sec.getStudentList().contains(studentRepository.findById(id).get())){
                    list = new ArrayList<>();
                    for (Student student:sec.getStudentList()
                         ) {
                        if(student.getId() != id)list.add(student);
                    }
                    sec.setStudentList(list);
                }
                list1.add(sec);
            }
            for(Section test: list1){
                sectionRepository.save(test);
            }
            s.setSectionList(list1);
            subjectRepository.save(s);
        }
        int delete = 10000000;
        for (SectionChecked s:sectionCheckRepository.findAll()
             ) {
            if(s.getStudent().getId()==id)delete=s.getId();
        }
        if(delete != 10000000)sectionCheckRepository.deleteById(delete);
        List<Scores> chk2 = new ArrayList<>();
        for (Scores sc:scoresRepository.findAll()
             ) {
            if(sc.getStudent().getId()==id)chk2.add(sc);
        }
        for (Scores sc: chk2){
            scoresRepository.delete(sc);
        }
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
