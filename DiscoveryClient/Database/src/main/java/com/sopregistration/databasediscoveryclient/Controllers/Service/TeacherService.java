package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.TeacherRepository;
import com.sopregistration.databasediscoveryclient.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;

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
        try {
            for (Teacher t: repository.findAll()
                 ) {
                if(t.getId() == id) {
                    try {
                        repository.delete(t);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }

                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
