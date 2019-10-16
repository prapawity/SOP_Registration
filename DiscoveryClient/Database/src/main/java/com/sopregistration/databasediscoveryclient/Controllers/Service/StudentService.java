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

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudent(int id){
        return studentRepository.getOne(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

}
