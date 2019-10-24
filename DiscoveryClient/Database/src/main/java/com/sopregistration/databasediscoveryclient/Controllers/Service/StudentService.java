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
            for (Student s: studentRepository.findAll()
                 ) {
                if(s.getId() == id) {
                    try {
                        studentRepository.delete(s);
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

    // delete


}
