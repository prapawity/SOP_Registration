package com.sopregistation.servicecrud;

import com.sopregistation.servicecrud.model.Array.StudentList;
import com.sopregistation.servicecrud.model.Student;
import com.sopregistation.servicecrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
//@RequestMapping("sopregistation/service/database")
public class ServicecrudApplication {
    @Autowired
    StudentService studentService;




    // define variable

    public static void main(String[] args) {
        SpringApplication.run(ServicecrudApplication.class, args);
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    StudentList Home(@RequestBody StudentList student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    StudentList allStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    Student studentID(@PathVariable int id){
        return studentService.getStudentByID(id);
    }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    Boolean studentDeleteID(@PathVariable int id){
        return studentService.deleteStudentByID(id);
    }


}
