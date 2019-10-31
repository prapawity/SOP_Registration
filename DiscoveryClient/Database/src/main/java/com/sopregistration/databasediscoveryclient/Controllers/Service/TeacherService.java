package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.TeacherRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.TeacherArray;
import com.sopregistration.databasediscoveryclient.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Boolean createTeacher(Teacher teacher){
        Teacher teacher1 = teacherRepository.save(teacher);
        return teacher1 != null ? true:false;
    }
     public Teacher getTeacherByID(String id){return teacherRepository.findById(id).get();}

     public TeacherArray getAllTeacher(){
        TeacherArray teacherArray = new TeacherArray(teacherRepository.findAll());
        return teacherArray;
     }

     public Boolean deleteTeacherByID(String id){
         try {
             teacherRepository.deleteById(id);
             return true;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
     }
}
