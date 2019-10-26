package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.ScoreRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionCheckRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.SectionRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.StudentRepository;
import com.sopregistration.databasediscoveryclient.model.Score;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.SectionCheckStudent;
import com.sopregistration.databasediscoveryclient.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionCheckRepository sectionCheckRepository;


    // Define variable

    public boolean createStudent(Student student){
        Student saved = studentRepository.save(student);
        return saved != null ? true : false;
        //case if want chk result
    }

    //create student

    public Student getStudent(int id){
        for (Student s: studentRepository.findAll()
             ) {
            if (id == s.getId()) return s;
        }
        return null;
    }

    // get student

    public List<Student> getAllStudent(){ return studentRepository.findAll(); }

    // getAll

    public Boolean deleteStudent(int id){
        try {
            List<Student> list = new ArrayList<Student>();
            for (Score s: scoreRepository.findAll()
                 ) {
                if(s.getStudent().getId() == id){
                    scoreRepository.delete(s);
                }
            }
            for (Section s: sectionRepository.findAll()
                 ) {
                list.clear();

                for (Student st: s.getStudentList()
                     ) {
                    if(st.getId() != id){
                        list.add(st);
                    }
                }
                s.setStudentList(list);
                sectionRepository.save(s);
            }
            for (SectionCheckStudent chk:sectionCheckRepository.findAll()){
                list.clear();
                for (Student s:chk.getStudent()
                     ) {
                    if(s.getId() != id){
                        list.add(s);
                    }
                }
                chk.setStudent(list);
                sectionCheckRepository.save(chk);
            }
            try {
                studentRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // delete


}
