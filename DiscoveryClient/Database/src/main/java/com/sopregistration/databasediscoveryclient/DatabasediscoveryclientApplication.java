package com.sopregistration.databasediscoveryclient;

import com.sopregistration.databasediscoveryclient.Controllers.Service.*;
import com.sopregistration.databasediscoveryclient.model.*;
import com.sopregistration.databasediscoveryclient.model.ArrayModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
//@RequestMapping("/api/v1/database")
public class DatabasediscoveryclientApplication {

    @Autowired
    private StudentService studentService;
    @Autowired
    private HongfahService hongfahService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SectionCheckService sectionCheckService;
    @Autowired
    DemographicService demographicService;


    public static void main(String[] args) {
        SpringApplication.run(DatabasediscoveryclientApplication.class, args);
    }

    ////////////////////////////////////////////    Student    ////////////////////////////////////////////

    @RequestMapping(value = "user/student/add", method = RequestMethod.POST)
    StudentArray addStudent(@RequestBody StudentArray studentList){
        Boolean chk;
        List<Student> list = new ArrayList<Student>();
        for (Student i:studentList.getStudentList()
        ) {
            chk = studentService.createStudent(i);
            if(chk == false){
                continue;
            }else {
                list.add(studentService.getStudentByID(i.getId()));
            }
        }
        StudentArray studentList1 = new StudentArray(list);
        return studentList1;
    }

    @RequestMapping(value = "user/student/update/{id}", method = RequestMethod.POST)
    Student updateStudent(@RequestBody Student student,@PathVariable int id){ return studentService.createStudent(student) != false ? studentService.getStudentByID(id) : null; }

    @RequestMapping(value = "user/student/{id}", method = RequestMethod.GET)
    Student getStudentByID(@PathVariable int id){ return studentService.getStudentByID(id); }

    @RequestMapping(value = "user/students", method = RequestMethod.GET)
    StudentArray getStudentAll(){ return studentService.getAllStudent(); }

    @RequestMapping(value = "user/student/delete/{id}", method = RequestMethod.GET)
    Boolean deleteStudentID(@PathVariable int id){ return studentService.deleteStudentByID(id); }


    ////////////////////////////////////////////    End - Student    ////////////////////////////////////////////




    ////////////////////////////////////////////    Score            ////////////////////////////////////////////

    @RequestMapping(value = "score/add", method = RequestMethod.POST)
    ScoreArray addScore(@RequestBody ScoreArray scoreList){
        List<Score> newscore = new ArrayList<Score>();
        ScoreArray scoreList1;
        newscore.clear();
        boolean chk;
        for (Score s: scoreList.getScoreList()
        ) {
            chk = scoreService.createScore(s);
            if(chk == false) {
                scoreList1 = new ScoreArray(newscore);
                return scoreList1;
            }
            else {
                newscore.add(scoreService.getScoreByID(s.getId()));
            }

        }
        scoreList1 = new ScoreArray(newscore);
        return scoreList1;
    }

    @RequestMapping(value = "score", method = RequestMethod.GET)
    ScoreArray getAllScore(){ return scoreService.getAllScore(); }

    @RequestMapping(value = "score/update/{id}", method = RequestMethod.POST)
    Score updateScore(@RequestBody Score score,@PathVariable int id){ return scoreService.createScore(score) != false ? scoreService.getScoreByID(id) : null; }

    @RequestMapping(value = "score/{id}", method = RequestMethod.GET)
    Score getScoreByID(@PathVariable int id){ return scoreService.getScoreByID(id); }

    @RequestMapping(value = "score/delete/{id}", method = RequestMethod.GET)
    Boolean deleteScoreID(@PathVariable int id){ return scoreService.deleteScore(id); }




    ////////////////////////////////////////////    End - Score    ////////////////////////////////////////////



    ////////////////////////////////////////////    HongFah        ////////////////////////////////////////////

    @RequestMapping(value = "user/hongfah/add", method = RequestMethod.POST)
    HongfahArray addStaffHongFah(@RequestBody HongfahArray hongFah){
        List<HongFah> newList = new ArrayList<HongFah>();
        HongfahArray hongFahList;
        boolean chk;
        for (HongFah h: hongFah.getHongFahList()
        ) {
            chk = hongfahService.createHongfah(h);
            if(chk == false) {
                hongFahList = new HongfahArray(newList);
                return hongFahList;
            }
            else {
                newList.add(hongfahService.getHongfahByID(h.getId()));
            }

        }
        hongFahList = new HongfahArray(newList);
        return hongFahList;
    }

    @RequestMapping(value = "user/hongfahs", method = RequestMethod.GET)
    HongfahArray getAllStaff(){ return hongfahService.getHongfahAll(); }

    @RequestMapping(value = "user/hongfah/{id}", method = RequestMethod.GET)
    HongFah getStaffByID(@PathVariable String id){
        return hongfahService.getHongfahByID(id);
    }

    @RequestMapping(value = "user/hongfah/update/{id}", method = RequestMethod.POST)
    HongFah updateHongfah(@RequestBody HongFah hongFah,@PathVariable String id){ return hongfahService.createHongfah(hongFah) != false ? hongfahService.getHongfahByID(id) : null; }

    @RequestMapping(value = "user/hongfah/delete/{id}", method = RequestMethod.GET)
    Boolean deleteHongfahID(@PathVariable String id){ return hongfahService.deleteHongfahByID(id); }




    ////////////////////////////////////////////    End - HongFah    ////////////////////////////////////////////



    ////////////////////////////////////////////    Teacher           ///////////////////////////////////////////

    @RequestMapping(value = "user/teacher/add", method = RequestMethod.POST)
    TeacherArray addTeacher(@RequestBody TeacherArray teachers){
        Boolean chk;
        List<Teacher> list = new ArrayList<Teacher>();
        TeacherArray teacherList;
        list.clear();
        for (Teacher i: teachers.getTeacherList()
        ) {
            chk = teacherService.createTeacher(i);
            if(chk == false){
                teacherList = new TeacherArray(list);
                return teacherList;
            }
            else{
                list.add(teacherService.getTeacherByID(i.getId()));
            }
        }
        teacherList = new TeacherArray(list);
        return teacherList;
    }

    @RequestMapping(value = "user/teacher/update/{id}", method = RequestMethod.POST)
    Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable String id){ return teacherService.createTeacher(teacher) != false ? teacherService.getTeacherByID(id) : null; }

    @RequestMapping(value = "user/teachers", method = RequestMethod.GET)
    TeacherArray getTeacherAll(){ return teacherService.getAllTeacher(); }

    @RequestMapping(value = "user/teacher/{id}", method = RequestMethod.GET)
    Teacher getTeacherByID(@PathVariable String id){ return teacherService.getTeacherByID(id); }

    @RequestMapping(value = "user/teacher/delete/{id}", method = RequestMethod.GET)
    Boolean deleteTeacherID(@PathVariable String id){ return teacherService.deleteTeacherByID(id); }



    ////////////////////////////////////////////    End - Teacher    ////////////////////////////////////////////



    ////////////////////////////////////////////       Demographic        ///////////////////////////////////////////

    @RequestMapping(value = "demographic/add", method = RequestMethod.POST)
    Demographic addDemo(@RequestBody Demographic demographic){
        Demographic demographic1 = new Demographic();
        return demographicService.createDemographic(demographic) == true ? demographicService.getDemoID(demographic.getId()) : demographic1;
    }
//    @RequestMapping(value = "demographic/update/{id}", method = RequestMethod.POST)
//    Demographic updateDemo(@RequestBody Demographic demographic, @PathVariable String id){
//        return demographicService.createDemographic(demographic) == true ? demographicService.getDemoID(id) : null;
//    }
//
//    @RequestMapping(value = "demographic", method = RequestMethod.GET)
//    DemographicList getAllDemo(){
//        DemographicList demographicList = new DemographicList(demographicService.getAllDemographic());
//        return demographicList; }
//
//    @RequestMapping(value = "demographic/{id}", method = RequestMethod.GET)
//    Demographic getDemoID(@PathVariable String id){ return demographicService.getDemoID(id); }
//
//    @RequestMapping(value = "demographic/delete/{id}", method = RequestMethod.GET)
//    Boolean deleteDemoID(@PathVariable String id){ return demographicService.deleteDemographic(id); }






//    ////////////////////////////////////////////    End - Demographic    ////////////////////////////////////////////

//    ////////////////////////////////////////////       Subject        ///////////////////////////////////////////
@RequestMapping(value = "subject/add", method = RequestMethod.POST)
Subject addSubject(@RequestBody Subject subject){
    Subject newSub = new Subject();
    return subjectService.createSubject(subject) == true ? subjectService.getSubjectByID(subject.getId()): newSub;
}

    // this service is important, why can't add by array

    @RequestMapping(value = "subject/update/{id}", method = RequestMethod.POST)
    Subject updateSubject(@RequestBody Subject subject,@PathVariable int id){ return subjectService.createSubject(subject) != false ? subjectService.getSubjectByID(id) : null; }

    @RequestMapping(value = "subject", method = RequestMethod.GET)
    SubjectArray getSubjectAll(){ return subjectService.getAllSubject();}

    @RequestMapping(value = "subject/{id}", method = RequestMethod.GET)
    Subject getSubjectByID(@PathVariable int id){ return subjectService.getSubjectByID(id); }

    @RequestMapping(value = "subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubjectID(@PathVariable int id){ return subjectService.deleteSubject(id); }





//    ////////////////////////////////////////////    End - Subject    ////////////////////////////////////////////




//    ////////////////////////////////////////////       Section        ///////////////////////////////////////////



    @RequestMapping(value = "section/add", method = RequestMethod.POST)
    SectionArray addSection(@RequestBody SectionArray sections){
    Boolean chk;
    SectionArray sectionList;
    List<Section> list = new ArrayList<Section>();
    list.clear();
    for (Section i: sections.getSectionList()
    ) {
        chk = sectionService.createSection(i);
        if(chk == false){
            sectionList = new SectionArray(list);
            return sectionList;
        }
        else{
            list.add(sectionService.getSectionByID(i.getId()));
        }
    }
    sectionList = new SectionArray(list);
    return sections;
}

    @RequestMapping(value = "section/update/{id}", method = RequestMethod.POST)
    Section updateSection(@RequestBody Section section,@PathVariable String id){ return sectionService.createSection(section) != false ? sectionService.getSectionByID(id) : null; }


    @RequestMapping(value = "section", method = RequestMethod.GET)
    SectionArray getSectionAll(){ return sectionService.getAllSection(); }

    @RequestMapping(value = "section/{id}", method = RequestMethod.GET)
    Section getSectionByID(@PathVariable String id){ return sectionService.getSectionByID(id); }

    @RequestMapping(value = "section/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSectionID(@PathVariable String id){ return sectionService.deleteSectionByID(id); }







//    ////////////////////////////////////////////    End - Section    ////////////////////////////////////////////



    ////////////////////////////////////////////    SectionCheck    ////////////////////////////////////////////

    @RequestMapping(value = "sectioncheck/add", method = RequestMethod.POST)
    SectionCheckArray addSectionCheck(@RequestBody SectionCheckArray sections){
        Boolean chk;
        SectionCheckArray sectionList;
        List<SectionChecked> list = new ArrayList<>();
        list.clear();
        for (SectionChecked i: sections.getCheckedList()
        ) {
            chk = sectionCheckService.createSectionCheck(i);
            if(chk == false){
                sectionList = new SectionCheckArray(list);
                return sectionList;
            }
            else{
                list.add(sectionCheckService.getSectionCheckByID(i.getId()));
            }
        }
        sectionList = new SectionCheckArray(list);
        return sections;
    }

    @RequestMapping(value = "sectioncheck/update/{id}", method = RequestMethod.POST)
    SectionChecked updateSectionCheck(@RequestBody SectionChecked section,@PathVariable int id){ return sectionCheckService.update(section, id) != false ? sectionCheckService.getSectionCheckByID(id) : null; }


    @RequestMapping(value = "SectionChecks", method = RequestMethod.GET)
    SectionCheckArray getSectionAllCheck(){ return sectionCheckService.getAllSectionCheck(); }

    @RequestMapping(value = "sectionCheck/{id}", method = RequestMethod.GET)
    SectionChecked getSectioncheckByID(@PathVariable int id){ return sectionCheckService.getSectionCheckByID(id); }

    @RequestMapping(value = "sectionCheck/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSectionCheckID(@PathVariable int id){ return sectionCheckService.deleteSectionCheck(id); }




    ////////////////////////////////////////////    End - SectionCheck    ////////////////////////////////////////////
}
