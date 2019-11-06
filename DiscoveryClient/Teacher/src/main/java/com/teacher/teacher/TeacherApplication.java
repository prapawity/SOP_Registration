package com.teacher.teacher;

import com.teacher.teacher.model.*;
import com.teacher.teacher.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class TeacherApplication {
    @Autowired
    private ViewScoreService viewScoreService;
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private ViewStudentService viewStudentService;
    @Autowired
    private ViewSubjectService viewSubjectService;
    @Autowired
    private ViewTeacherService viewTeacherService;

    public static void main(String[] args) {

        SpringApplication.run(TeacherApplication.class, args);
    }

    @RequestMapping(value = "/student/view", method = RequestMethod.GET)
    Student viewPersoninfo(@PathVariable int id){ return viewStudentService.getStudent(id); }

    @RequestMapping(value = "/subject/view", method = RequestMethod.GET)
    Subject viewSubjectdemo(@PathVariable int id){ return viewSubjectService.getSubject(id); }

    @RequestMapping(value = "/score/{id}", method = RequestMethod.GET)
    Score viewScore(@PathVariable String id){ return null; }
}
