package com.sopreg.student;

import com.sopreg.student.model.Student;
import com.sopreg.student.model.Subject;
import com.sopreg.student.service.ViewStudentService;
import com.sopreg.student.service.ViewSubjectService;
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

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @RequestMapping(value = "/student/view", method = RequestMethod.GET)
    Student viewPersoninfo(@PathVariable int id){ return viewStudentService.getStudent(id); }

    @RequestMapping(value = "/subject/view", method = RequestMethod.GET)
    Subject viewSubjectdemo(@PathVariable int id){ return viewSubjectService.getSubject; }

    @RequestMapping(value = "/score/{id}", method = RequestMethod.GET)
    Subject viewScore(@PathVariable String id){ return null; }
}
