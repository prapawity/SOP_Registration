package com.sopregistration.databasediscoveryclient;

import com.sopregistration.databasediscoveryclient.Controllers.Service.*;
import com.sopregistration.databasediscoveryclient.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
@RestController
//@RequestMapping("/api/v1/database")
public class DatabasediscoveryclientApplication {
    @Autowired
    StudentService studentService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    HongFahService hongFahService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    DemographicService demographicService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SectionService sectionService;

    public static void main(String[] args) {
        SpringApplication.run(DatabasediscoveryclientApplication.class, args);
    }



    ////////////////////////////////////////////    Student    ////////////////////////////////////////////


    @RequestMapping(value = "user/student/add", method = RequestMethod.POST)
    List<Student> addStudent(@RequestBody List<Student> student){
        Boolean chk;
        List<Student> list = new ArrayList<Student>();
        for (Student i:student
             ) {
            chk = studentService.createStudent(i);
            if(chk == false){
                continue;
            }else {
                list.add(studentService.getStudent(i.getId()));
            }
        }
        return list;
    }

    @RequestMapping(value = "user/student/update/{id}", method = RequestMethod.POST)
    Student updateStudent(@RequestBody Student student,@PathVariable int id){ return studentService.createStudent(student) != false ? studentService.getStudent(id) : null; }

    @RequestMapping(value = "user/student", method = RequestMethod.GET)
    List<Student> getStudentAll(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "user/student/{id}", method = RequestMethod.GET)
    Student getStudentByID(@PathVariable int id){ return studentService.getStudent(id); }

    @RequestMapping(value = "user/student/delete/{id}", method = RequestMethod.GET)
    Boolean deleteStudentID(@PathVariable int id){ return studentService.deleteStudent(id); }



    ////////////////////////////////////////////    End - Student    ////////////////////////////////////////////




    ////////////////////////////////////////////    Score            ////////////////////////////////////////////


    @RequestMapping(value = "score/add", method = RequestMethod.POST)
    List<Score> addScore(@RequestBody  List<Score> scoreList){
        List<Score> newscore = new ArrayList<Score>();
        newscore.clear();
        boolean chk;
        for (Score s: scoreList
             ) {
            chk = scoreService.createScore(s);
            if(chk == false) return newscore;
            else {
                newscore.add(scoreService.getScoreID(s.getId()));
            }

        }
        return newscore;
    }

    @RequestMapping(value = "score", method = RequestMethod.GET)
    List<Score> getAllScore(){
        return scoreService.getAllScore();
    }

    @RequestMapping(value = "score/update/{id}", method = RequestMethod.POST)
    Score updateScore(@RequestBody Score score,@PathVariable int id){ return scoreService.createScore(score) != false ? scoreService.getScoreID(id) : null; }

    @RequestMapping(value = "score/{id}", method = RequestMethod.GET)
    Score getScoreByID(@PathVariable int id){ return scoreService.getScoreID(id); }

    @RequestMapping(value = "score/delete/{id}", method = RequestMethod.GET)
    Boolean deleteScoreID(@PathVariable int id){ return scoreService.deleteScore(id); }



    ////////////////////////////////////////////    End - Score    ////////////////////////////////////////////






    ////////////////////////////////////////////    HongFah        ////////////////////////////////////////////


    @RequestMapping(value = "user/hongfah/add", method = RequestMethod.POST)
    List<HongFah> addStaffHongFah(@RequestBody List<HongFah> hongFah){
        List<HongFah> newList = new ArrayList<HongFah>();
        boolean chk;
        for (HongFah h: hongFah
        ) {
            chk = hongFahService.createHongfah(h);
            if(chk == false) return newList;
            else {
                newList.add(hongFahService.getHongfah(h.getId()));
            }

        }
        return newList;
    }

    @RequestMapping(value = "user/hongfah", method = RequestMethod.GET)
    List<HongFah> getAllStaff(){
        return hongFahService.getAllHongfah();
    }

    @RequestMapping(value = "user/hongfah/{id}", method = RequestMethod.GET)
    HongFah getStaffByID(@PathVariable int id){
        return hongFahService.getHongfah(id);
    }

    @RequestMapping(value = "user/hongfah/update/{id}", method = RequestMethod.POST)
    HongFah updateHongfah(@RequestBody HongFah hongFah,@PathVariable int id){ return hongFahService.createHongfah(hongFah) != false ? hongFahService.getHongfah(id) : null; }

    @RequestMapping(value = "user/hongfah/delete/{id}", method = RequestMethod.GET)
    Boolean deleteHongfahID(@PathVariable int id){ return hongFahService.deleteHongfah(id); }




    ////////////////////////////////////////////    End - HongFah    ////////////////////////////////////////////



    ////////////////////////////////////////////    Teacher           ///////////////////////////////////////////

    @RequestMapping(value = "user/teacher/add", method = RequestMethod.POST)
    List<Teacher> addTeacher(@RequestBody List<Teacher> teachers){
        Boolean chk;
        List<Teacher> list = new ArrayList<Teacher>();
        list.clear();
        for (Teacher i: teachers
        ) {
            chk = teacherService.createTeacher(i);
            if(chk == false){ return list;}
            else{
                list.add(teacherService.getTeacher(i.getId()));
            }
        }
        return list;
    }

    @RequestMapping(value = "user/teacher/update/{id}", method = RequestMethod.POST)
    Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable int id){ return teacherService.createTeacher(teacher) != false ? teacherService.getTeacher(id) : null; }

    @RequestMapping(value = "user/teacher", method = RequestMethod.GET)
    List<Teacher> getTeacherAll(){
        return teacherService.getAllTeacher();
    }

    @RequestMapping(value = "user/teacher/{id}", method = RequestMethod.GET)
    Teacher getTeacherByID(@PathVariable int id){ return teacherService.getTeacher(id); }

    @RequestMapping(value = "user/teacher/delete/{id}", method = RequestMethod.GET)
    Boolean deleteTeacherID(@PathVariable int id){ return teacherService.deleteTeacher(id); }


    ////////////////////////////////////////////    End - Teacher    ////////////////////////////////////////////





    ////////////////////////////////////////////       Demographic        ///////////////////////////////////////////

    @RequestMapping(value = "demographic/add", method = RequestMethod.POST)
    Demographic addDemo(@RequestBody Demographic demographic){
        Demographic demographic1 = new Demographic();
        return demographicService.createDemographic(demographic) == true ? demographicService.getDemoID(demographic.getId()) : demographic1;
    }
    @RequestMapping(value = "demographic/update/{id}", method = RequestMethod.POST)
    Demographic updateDemo(@RequestBody Demographic demographic, @PathVariable String id){
        return demographicService.createDemographic(demographic) == true ? demographicService.getDemoID(id) : null;
    }

    @RequestMapping(value = "demographic", method = RequestMethod.GET)
    List<Demographic> getAllDemo(){ return demographicService.getAllDemographic(); }

    @RequestMapping(value = "demographic/{id}", method = RequestMethod.GET)
    Demographic getDemoID(@PathVariable String id){ return demographicService.getDemoID(id); }

    @RequestMapping(value = "demographic/delete/{id}", method = RequestMethod.GET)
    Boolean deleteDemoID(@PathVariable String id){ return demographicService.deleteDemographic(id); }



    ////////////////////////////////////////////    End - Demographic    ////////////////////////////////////////////





    ////////////////////////////////////////////       Subject        ///////////////////////////////////////////

    @RequestMapping(value = "subject/add", method = RequestMethod.POST)
    Subject addSubject(@RequestBody Subject subject){
        Subject newSub = new Subject();
        return subjectService.createSubject(subject) == true ? subjectService.getSubjectID(subject.getId()): newSub;
    }

    // this service is important, why can't add by array

    @RequestMapping(value = "subject/update/{id}", method = RequestMethod.POST)
    Subject updateSubject(@RequestBody Subject subject,@PathVariable int id){ return subjectService.createSubject(subject) != false ? subjectService.getSubjectID(id) : null; }

    @RequestMapping(value = "subject", method = RequestMethod.GET)
    List<Subject> getSubjectAll(){
        return subjectService.getAllSubject();
    }

    @RequestMapping(value = "subject/{id}", method = RequestMethod.GET)
    Subject getSubjectByID(@PathVariable int id){ return subjectService.getSubjectID(id); }

    @RequestMapping(value = "subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubjectID(@PathVariable int id){ return subjectService.deleteSubject(id); }



    ////////////////////////////////////////////    End - Subject    ////////////////////////////////////////////


    ////////////////////////////////////////////       Section        ///////////////////////////////////////////

    @RequestMapping(value = "section/add", method = RequestMethod.POST)
    List<Section> addSection(@RequestBody List<Section> sections){
        Boolean chk;
        List<Section> list = new ArrayList<Section>();
        list.clear();
        for (Section i: sections
        ) {
            chk = sectionService.createSection(i);
            if(chk == false){ return list;}
            else{
                list.add(sectionService.getSectionByID(i.getId()));
            }
        }
        return list;
    }

    @RequestMapping(value = "section/update/{id}", method = RequestMethod.POST)
    Section updateSection(@RequestBody Section section,@PathVariable String id){ return sectionService.createSection(section) != false ? sectionService.getSectionByID(id) : null; }


    @RequestMapping(value = "Section", method = RequestMethod.GET)
    List<Section> getSectionAll(){
        return sectionService.getAllSection();
    }

    @RequestMapping(value = "section/{id}", method = RequestMethod.GET)
    Section getSubjectByID(@PathVariable String id){ return sectionService.getSectionByID(id); }

    @RequestMapping(value = "section/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSectionID(@PathVariable String id){ return sectionService.deleteSection(id); }



    ////////////////////////////////////////////    End - Section    ////////////////////////////////////////////


}
