package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.StudentRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.StudentArray;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.SectionChecked;
import com.sopregistration.databasediscoveryclient.model.Student;
import com.sopregistration.databasediscoveryclient.model.Subject;
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
            s.setSectionList(list1);
            subjectRepository.save(s);
        }
        for (SectionChecked s:sectionCheckRepository.findAll()
             ) {
            if(s.getStudent().getId()==id)sectionCheckRepository.delete(s);
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
