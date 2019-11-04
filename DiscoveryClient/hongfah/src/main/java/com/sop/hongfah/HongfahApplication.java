package com.sop.hongfah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableDiscoveryClient
public class HongfahApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongfahApplication.class, args);
    }
    @RequestMapping(value = "/subject/create", method = RequestMethod.POST)
    Subject createSubject(@RequestBody Subject sectionList){
        return null;
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    Subject getSubject(){
        return null;
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    Subject getSectionByID(@PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/subject/update/{id}", method = RequestMethod.POST)
    Subject updateSubjectByid(@RequestBody Subject subject, @PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.GET)
    Boolean deleteSubjectById(@PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/visual/teacher/{id}", method = RequestMethod.GET)
    Teacher visualTeacher(@PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/visual/student/{id}", method = RequestMethod.GET)
    Student visualStudent(@PathVariable String id){
        return null;
    }

}
