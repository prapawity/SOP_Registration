package com.sopregistation.servicecrud;

import com.sopregistation.servicecrud.model.*;
import com.sopregistation.servicecrud.model.Array.*;
import com.sopregistation.servicecrud.service.*;
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
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ScoreService scoresService;


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



    /////////////////////////////////// Scores //////////////////////////////////////

    @RequestMapping(value = "/scores/create", method = RequestMethod.POST)
    ScoresList createScores(@RequestBody ScoresList scores){ return scoresService.createScores(scores); }

    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    ScoresList allScores(){
        return scoresService.getAllScores();
    }

    @RequestMapping(value = "/scores/{id}", method = RequestMethod.GET)
    Scores getScoresByID(@PathVariable int id){ return scoresService.getScoresByID(id); }

    @RequestMapping(value = "/scores/update/{id}", method = RequestMethod.POST)
    Scores updateScoresByID(@RequestBody Scores scores,@PathVariable int id){ return scoresService.updateScores(scores,id); }

    @RequestMapping(value = "/scores/delete/{id}", method = RequestMethod.GET)
    Boolean scoresDeleteByID(@PathVariable int id){
        return scoresService.deleteScoresByID(id);
    }


    //////////////////////////////////////// end Scores ///////////////////////////////////////////



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

    ////////////////////////////////////////   end Section  ///////////////////////////////////////////

    //////////////////////////////////////////    Subject    ///////////////////////////////////////////

    @RequestMapping(value = "/subject/create", method = RequestMethod.POST)
    Subject createTeacher(@RequestBody Subject subject){return subjectService.createSubject(subject);}

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    SubjectList getAllSubject(){return subjectService.getAllSubject();}

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    Subject getSubjectByID(@PathVariable String id){return subjectService.getSubjectByID(id);}

    @RequestMapping(value = "/subject/update/{id}", method = RequestMethod.POST)
    Subject updateSubjectByid(@RequestBody Subject s, @PathVariable String id){return subjectService.updateSubject(s,id);}

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubject(@PathVariable String id){return subjectService.deleteSubjectByID(id);}

    ////////////////////////////////////////   end Subject   ///////////////////////////////////////////
}
