package com.sopregistration.databasediscoveryclient;

import com.sopregistration.databasediscoveryclient.Controllers.Service.HongFahService;
import com.sopregistration.databasediscoveryclient.Controllers.Service.ScoreService;
import com.sopregistration.databasediscoveryclient.Controllers.Service.StudentService;
import com.sopregistration.databasediscoveryclient.model.HongFah;
import com.sopregistration.databasediscoveryclient.model.Score;
import com.sopregistration.databasediscoveryclient.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    public static void main(String[] args) {
        SpringApplication.run(DatabasediscoveryclientApplication.class, args);
    }



    ////////////////////////////////////////////    Student    ////////////////////////////////////////////


    @RequestMapping(value = "student/add", method = RequestMethod.POST)
    Student addStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return student;
    }
    @RequestMapping(value = "student", method = RequestMethod.GET)
    List<Student> getStudentAll(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    Student getStudentByID(@PathVariable int id){
        return studentService.getStudent(id);
    }



    ////////////////////////////////////////////    End - Student    ////////////////////////////////////////////




    ////////////////////////////////////////////    Score            ///////////////////////////////////////////


    @RequestMapping(value = "score/add", method = RequestMethod.POST)
    Score addScore(@RequestBody Score score){
        scoreService.createScore(score);
        return score;
    }

    @RequestMapping(value = "score", method = RequestMethod.GET)
    List<Score> getAllScore(){
        return scoreService.getAllScore();
    }



    ////////////////////////////////////////////    End - Score    ////////////////////////////////////////////






    ////////////////////////////////////////////    HongFah        ////////////////////////////////////////////


    @RequestMapping(value = "hongfah/staff/create", method = RequestMethod.POST)
    HongFah addStaffHongFah(@RequestBody HongFah hongFah){
        return hongFahService.createStaff(hongFah);
    }

    @RequestMapping(value = "hongfah", method = RequestMethod.GET)
    List<HongFah> getAllStaff(){
        return hongFahService.getAllStaff();
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    HongFah getStaffByID(@PathVariable int id){
        return hongFahService.getStaffByID(id);
    }





    ////////////////////////////////////////////    End - HongFah    ////////////////////////////////////////////




}
