package com.sopreg.student;

import com.sopreg.student.model.*;
import com.sopreg.student.model.array.*;
import com.sopreg.student.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class StudentApplication {
    @Autowired
    private ViewStudentService viewStudentService;
    @Autowired
    private ViewSubjectService viewSubjectService;
    @Autowired
    private AttendClassService attendClassService;
    @Autowired
    private ViewScoreService viewScoreService;

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @RequestMapping(value = "/student/view/{id}", method = RequestMethod.GET)
    Student viewStudent(@PathVariable int id){ return viewStudentService.getStudent(id); }

    @RequestMapping(value = "/subject/view", method = RequestMethod.GET)
    SubjectList viewSubject(){ return viewSubjectService.getAllSubject(); }

    @RequestMapping(value = "/score/view/{id}", method = RequestMethod.GET)
    Score viewScore(@PathVariable int id){ return viewScoreService.getScoreByID(id); }

    @RequestMapping(value = "/score/view", method = RequestMethod.GET)
    ScoreList viewScoreboard(){ return viewScoreService.getAllScore(); }  //to see everyone's score(for testing)

    @RequestMapping(value = "/sectioncheck/{id}", method = RequestMethod.GET)
    SectionCheckList classAttendance(@PathVariable int id){ return attendClassService.getAllCheckstatusByID(id); }
}
