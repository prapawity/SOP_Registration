package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.TeacherRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.TeacherArray;
import com.sopregistration.databasediscoveryclient.model.Subject;
import com.sopregistration.databasediscoveryclient.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;

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
         List<Teacher> list;
         for (Subject s:subjectRepository.findAll()
         ) {
             if(s.getTeacherList().contains(teacherRepository.findById(id).get())){
                 list = new ArrayList<>();
                 for (Teacher t:s.getTeacherList()
                 ) {
                     if(t.getId() != id)list.add(t);
                 }
                 s.setTeacherList(list);
                 subjectRepository.save(s);
             }
         }
         try {
             teacherRepository.deleteById(id);
             return true;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
     }
}
