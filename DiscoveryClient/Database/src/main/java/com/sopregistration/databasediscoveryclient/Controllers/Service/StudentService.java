package com.sopregistration.databasediscoveryclient.Controllers.Service;

import com.sopregistration.databasediscoveryclient.Controllers.Repository.StudentRepository;
import com.sopregistration.databasediscoveryclient.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sopregistration.databasediscoveryclient.model.Sex.Men;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public boolean createStudent(Student student){
        Student saved = studentRepository.save(student);
        return saved != null ? true: false;
        //case if want chk result
    }

    public Student getStudent(int id){
        for (Student s: studentRepository.findAll()
             ) {
            if (id == s.getId()) return s;
        }
        return null;
    }

    public List<Student> getAllStudent(){ return studentRepository.findAll(); }

    public Boolean deleteStudent(int id){
        try {
            studentRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
