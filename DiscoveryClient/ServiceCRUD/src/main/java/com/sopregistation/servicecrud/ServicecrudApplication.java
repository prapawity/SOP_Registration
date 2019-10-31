package com.sopregistation.servicecrud;

import com.sopregistation.servicecrud.model.Array.HongfahList;
import com.sopregistation.servicecrud.model.Array.SectionList;
import com.sopregistation.servicecrud.model.Array.StudentList;
import com.sopregistation.servicecrud.model.Array.TeacherList;
import com.sopregistation.servicecrud.model.HongFah;
import com.sopregistation.servicecrud.model.Section;
import com.sopregistation.servicecrud.model.Student;
import com.sopregistation.servicecrud.model.Teacher;
import com.sopregistation.servicecrud.service.HongfahService;
import com.sopregistation.servicecrud.service.SectionService;
import com.sopregistation.servicecrud.service.StudentService;
import com.sopregistation.servicecrud.service.TeacherService;
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
    private StudentService studentService;
    @Autowired
    private HongfahService hongfahService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SectionService sectionService;



    // define variable

    public static void main(String[] args) {
        SpringApplication.run(ServicecrudApplication.class, args);
    }

    /////////////////////////////////// Student //////////////////////////////////////

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    StudentList createStudent(@RequestBody StudentList student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    StudentList allStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    Student studentID(@PathVariable int id){ return studentService.getStudentByID(id); }

    @RequestMapping(value = "/student/update/{id}", method = RequestMethod.POST)
    Student updateStudentID(@RequestBody Student student,@PathVariable int id){ return studentService.updateStudent(student,id); }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    Boolean studentDeleteID(@PathVariable int id){
        return studentService.deleteStudentByID(id);
    }


    //////////////////////////////////////// end Student ///////////////////////////////////////////



    ////////////////////////////////////////////// Hongfah ////////////////////////////////////////////////

    @RequestMapping(value = "/hongfah/create", method = RequestMethod.POST)
    HongfahList createHongfah(@RequestBody HongfahList hongfahList){return hongfahService.createHongfahStaff(hongfahList);}

    @RequestMapping(value = "/hongfah", method = RequestMethod.GET)
    HongfahList getAllHongfah(){return hongfahService.getAllHongfah();}

    @RequestMapping(value = "/hongfah/{id}", method = RequestMethod.GET)
    HongFah getHongfahByID(@PathVariable String id){return hongfahService.getHongfahByID(id);}

    @RequestMapping(value = "/hongfah/update/{id}", method = RequestMethod.POST)
    HongFah updateHongfahByid(@RequestBody HongFah hongFah, @PathVariable String id){return hongfahService.updateHongfah(hongFah,id);}

    @RequestMapping(value = "/hongfah/delete/{id}", method = RequestMethod.GET)
    Boolean deleteHongfah(@PathVariable String id){return hongfahService.deleteHongfahByID(id);}

    ////////////////////////////////////////////// end Hongfah ////////////////////////////////////////////




    //////////////////////////////////////////    Teacher    ///////////////////////////////////////////

    @RequestMapping(value = "/teacher/create", method = RequestMethod.POST)
    TeacherList createTeacher(@RequestBody TeacherList teacherList){return teacherService.createTeacher(teacherList);}

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    TeacherList getAllTeacher(){return teacherService.getAllTeachers();}

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    Teacher getTeacherByID(@PathVariable String id){return teacherService.getTeacherByID(id);}

    @RequestMapping(value = "/teacher/update/{id}", method = RequestMethod.POST)
    Teacher updateTeacherByid(@RequestBody Teacher t, @PathVariable String id){return teacherService.updateTeacher(t,id);}

    @RequestMapping(value = "/teacher/delete/{id}", method = RequestMethod.GET)
    Boolean deleteTeacher(@PathVariable String id){return teacherService.deleteTeacherByID(id);}

    ////////////////////////////////////////   end teacher   ///////////////////////////////////////////



    ////////////////////////////////////////   Section   ///////////////////////////////////////////


    @RequestMapping(value = "/section/create", method = RequestMethod.POST)
    SectionList createTeacher(@RequestBody SectionList sectionList){return sectionService.createSection(sectionList);}

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    SectionList getSection(){return sectionService.getAllSection();}

    @RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
    Section getSectionByID(@PathVariable String id){return sectionService.getSectionByID(id);}

    @RequestMapping(value = "/section/update/{id}", method = RequestMethod.POST)
    Section updateSectionByid(@RequestBody Section section, @PathVariable String id){return sectionService.updateSectionByID(section,id);}

    @RequestMapping(value = "/section/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSection(@PathVariable String id){return sectionService.deleteSectionByID(id);}


} ////////////////////////////////////////   end Section  ///////////////////////////////////////////
