package com.sopregistration.databasediscoveryclient;

import com.sopregistration.databasediscoveryclient.Controllers.Service.*;
import com.sopregistration.databasediscoveryclient.model.*;
import com.sopregistration.databasediscoveryclient.model.Array.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
@EnableEurekaClient
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

    @RequestMapping(value = "database/hell", method = RequestMethod.GET)
    String chk(){
        return "Hi";
    }


    ////////////////////////////////////////////    Student    ////////////////////////////////////////////


    @RequestMapping(value = "user/student/add", method = RequestMethod.POST)
    StudentList addStudent(@RequestBody StudentList studentList){
        Boolean chk;
        List<Student> list = new ArrayList<Student>();
        for (Student i:studentList.getStudentList()
             ) {
            chk = studentService.createStudent(i);
            if(chk == false){
                continue;
            }else {
                list.add(studentService.getStudent(i.getId()));
            }
        }
        StudentList studentList1 = new StudentList(list);
        return studentList1;
    }

    @RequestMapping(value = "user/student/update/{id}", method = RequestMethod.POST)
    Student updateStudent(@RequestBody Student student,@PathVariable int id){ return studentService.createStudent(student) != false ? studentService.getStudent(id) : null; }

    @RequestMapping(value = "user/student", method = RequestMethod.GET)
    StudentList getStudentAll(){
        StudentList studentList = new StudentList(studentService.getAllStudent());
        return studentList;
    }

    @RequestMapping(value = "user/student/{id}", method = RequestMethod.GET)
    Student getStudentByID(@PathVariable int id){ return studentService.getStudent(id); }


    @RequestMapping(value = "user/student/delete/{id}", method = RequestMethod.GET)
    Boolean deleteStudentID(@PathVariable int id){ return studentService.deleteStudent(id); }



    ////////////////////////////////////////////    End - Student    ////////////////////////////////////////////




    ////////////////////////////////////////////    Score            ////////////////////////////////////////////


    @RequestMapping(value = "score/add", method = RequestMethod.POST)
    ScoreList addScore(@RequestBody ScoreList scoreList){
        List<Score> newscore = new ArrayList<Score>();
        ScoreList scoreList1;
        newscore.clear();
        boolean chk;
        for (Score s: scoreList.getScoreList()
             ) {
            chk = scoreService.createScore(s);
            if(chk == false) {
                scoreList1 = new ScoreList(newscore);
                return scoreList1;
            }
            else {
                newscore.add(scoreService.getScoreID(s.getId()));
            }

        }
        scoreList1 = new ScoreList(newscore);
        return scoreList1;
    }

    @RequestMapping(value = "score", method = RequestMethod.GET)
    ScoreList getAllScore(){
        ScoreList scoreList = new ScoreList(scoreService.getAllScore());
        return scoreList;
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
    HongFahList addStaffHongFah(@RequestBody HongFahList hongFah){
        List<HongFah> newList = new ArrayList<HongFah>();
        HongFahList hongFahList;
        boolean chk;
        for (HongFah h: hongFah.getHongFahList()
        ) {
            chk = hongFahService.createHongfah(h);
            if(chk == false) {
                hongFahList = new HongFahList(newList);
                return hongFahList;
            }
            else {
                newList.add(hongFahService.getHongfah(h.getId()));
            }

        }
        hongFahList = new HongFahList(newList);
        return hongFahList;
    }

    @RequestMapping(value = "user/hongfah", method = RequestMethod.GET)
    HongFahList getAllStaff(){
        HongFahList hongFahList = new HongFahList(hongFahService.getAllHongfah());
        return hongFahList;
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
    TeacherList addTeacher(@RequestBody TeacherList teachers){
        Boolean chk;
        List<Teacher> list = new ArrayList<Teacher>();
        TeacherList teacherList;
        list.clear();
        for (Teacher i: teachers.getTeacherList()
        ) {
            chk = teacherService.createTeacher(i);
            if(chk == false){
                teacherList = new TeacherList(list);
                return teacherList;
            }
            else{
                list.add(teacherService.getTeacher(i.getId()));
            }
        }
        teacherList = new TeacherList(list);
        return teacherList;
    }

    @RequestMapping(value = "user/teacher/update/{id}", method = RequestMethod.POST)
    Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable int id){ return teacherService.createTeacher(teacher) != false ? teacherService.getTeacher(id) : null; }

    @RequestMapping(value = "user/teacher", method = RequestMethod.GET)
    TeacherList getTeacherAll(){
        TeacherList teacherList = new TeacherList(teacherService.getAllTeacher());
        return teacherList;
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
    DemographicList getAllDemo(){
        DemographicList demographicList = new DemographicList(demographicService.getAllDemographic());
        return demographicList; }

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
    SubjectList getSubjectAll(){
        SubjectList subjectList = new SubjectList(subjectService.getAllSubject());
        return subjectList;
    }

    @RequestMapping(value = "subject/{id}", method = RequestMethod.GET)
    Subject getSubjectByID(@PathVariable int id){ return subjectService.getSubjectID(id); }

    @RequestMapping(value = "subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubjectID(@PathVariable int id){ return subjectService.deleteSubject(id); }



    ////////////////////////////////////////////    End - Subject    ////////////////////////////////////////////


    ////////////////////////////////////////////       Section        ///////////////////////////////////////////

    @RequestMapping(value = "section/add", method = RequestMethod.POST)
    SectionList addSection(@RequestBody SectionList sections){
        Boolean chk;
        SectionList sectionList;
        List<Section> list = new ArrayList<Section>();
        list.clear();
        for (Section i: sections.getSectionLists()
        ) {
            chk = sectionService.createSection(i);
            if(chk == false){
                sectionList = new SectionList(list);
                return sectionList;
            }
            else{
                list.add(sectionService.getSectionByID(i.getId()));
            }
        }
        sectionList = new SectionList(list);
        return sectionList;
    }

    @RequestMapping(value = "section/update/{id}", method = RequestMethod.POST)
    Section updateSection(@RequestBody Section section,@PathVariable String id){ return sectionService.createSection(section) != false ? sectionService.getSectionByID(id) : null; }


    @RequestMapping(value = "Section", method = RequestMethod.GET)
    SectionList getSectionAll(){
        SectionList sectionList = new SectionList(sectionService.getAllSection());
        return sectionList;
    }

    @RequestMapping(value = "section/{id}", method = RequestMethod.GET)
    Section getSubjectByID(@PathVariable String id){ return sectionService.getSectionByID(id); }

    @RequestMapping(value = "section/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSectionID(@PathVariable String id){ return sectionService.deleteSection(id); }



    ////////////////////////////////////////////    End - Section    ////////////////////////////////////////////


}
