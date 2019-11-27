package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.SubjectRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.Subject_TeacherRepository;
import com.sopregistration.databasediscoveryclient.Controllers.Repository.TeacherRepository;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.TeacherArray;
import com.sopregistration.databasediscoveryclient.model.Subject;
import com.sopregistration.databasediscoveryclient.model.Subject_Teacher;
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
    private Subject_TeacherRepository subjectRepository;
    @Autowired
    private  SubjectRepository sub;

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
         List<Subject_Teacher> subject_teachers = new ArrayList<>();
         for (Subject_Teacher s:subjectRepository.findAll()
         ) {
             if(s.getTeacher().getId() == id){
                 subject_teachers.add(s);
             }
         }
         for (Subject s:sub.findAll()
              ) {
             List<Subject_Teacher> chk = new ArrayList<>();
             for (Subject_Teacher ss:s.getTeacherList()
                  ) {

                 Boolean state = true;
                 for (Subject_Teacher st:subject_teachers
                      ) {
                     if(ss.getId() == st.getId())state=false;
                 }
                 if(state == true)chk.add(ss);
             }
             s.setTeacherList(chk);
             sub.save(s);
         }
         for (Subject_Teacher sj:subject_teachers
              ) {
             subjectRepository.delete(sj);
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
