package com.sop.hongfah;

import com.sop.hongfah.model.Array.StudentList;
import com.sop.hongfah.model.Array.SubjectList;
import com.sop.hongfah.model.Array.TeacherList;
import com.sop.hongfah.model.Student;
import com.sop.hongfah.model.Subject;
import com.sop.hongfah.model.Teacher;
import com.sop.hongfah.service.StudentService;
import com.sop.hongfah.service.SubjectService;
import com.sop.hongfah.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HongfahApplication {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    //######################## CRUD Subject ############################//
    public static void main(String[] args) {
        SpringApplication.run(HongfahApplication.class, args);
    }
    @RequestMapping(value = "/subject/create", method = RequestMethod.POST)
    Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    SubjectList getSubject(){
        return subjectService.getAllSubject();
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    Subject getSectionByID(@PathVariable String id){
        return subjectService.getSubjectByID(id);
    }

    @RequestMapping(value = "/subject/update/{id}", method = RequestMethod.POST)
    Subject updateSubjectByid(@RequestBody Subject subject, @PathVariable String id){
        return subjectService.updateSubject(subject,id);
    }

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubjectByID(@PathVariable String id){
        return subjectService.deleteSubjectByID(id);
    }

    //######################## CRUD Teacher ############################//

    @RequestMapping(value = "/teacher/create", method = RequestMethod.POST)
    TeacherList createTeacher(@RequestBody TeacherList teacherList){
        return teacherService.createTeacher(teacherList);
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    TeacherList getAllTeacher(){
        return teacherService.getAllTeachers();
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    Teacher getTeacherByID(@PathVariable String id){
        return teacherService.getTeacherByID(id);
    }

    @RequestMapping(value = "/teacher/update/{id}", method = RequestMethod.POST)
    Teacher updateTeacherByid(@RequestBody Teacher t, @PathVariable String id){
        return teacherService.updateTeacher(t,id);
    }

    @RequestMapping(value = "/teacher/delete/{id}", method = RequestMethod.GET)
    Boolean deleteTeacher(@PathVariable String id){
        return teacherService.deleteTeacherByID(id);
    }

    //######################## CRUD Student ############################//

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    StudentList createStudent(@RequestBody StudentList student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    StudentList getStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    Student getStudentByID(@PathVariable int id){
        return studentService.getStudentByID(id);
    }

    @RequestMapping(value = "/student/update/{id}", method = RequestMethod.POST)
    Student updateStudentByID(@RequestBody Student student,@PathVariable int id){
        return studentService.updateStudent(student,id);
    }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    Boolean deleteStudentByID(@PathVariable int id){
        return studentService.deleteStudentByID(id);
    }

}
