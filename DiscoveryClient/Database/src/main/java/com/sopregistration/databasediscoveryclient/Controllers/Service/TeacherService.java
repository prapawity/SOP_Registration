package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.TeacherRepository;
import com.sopregistration.databasediscoveryclient.model.Subject;
import com.sopregistration.databasediscoveryclient.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;

    @Autowired
    SubjectRepository subjectRepository;

    public boolean createTeacher(Teacher teacher){
        Teacher saved = repository.save(teacher);
        return saved != null ? true: false;
        //case if want chk result
    }

    public Teacher getTeacher(int id){
        for (Teacher s: repository.findAll()
        ) {
            if (id == s.getId()) return s;
        }
        return null;
    }

    public List<Teacher> getAllTeacher(){ return repository.findAll(); }

    public Boolean deleteTeacher(int id){
        List<Teacher> teachers = new ArrayList<>();
        for (Subject s:subjectRepository.findAll()
             ) {
            teachers.clear();
            for (Teacher t:s.getTeacherList()
                 ) {
                if(t.getId() != id){
                    teachers.add(t);
                }
            }
            s.setTeacherList(teachers);
            subjectRepository.save(s);
        }

        try {
            repository.deleteById(id);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
