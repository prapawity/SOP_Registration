package com.sopregistration.databasediscoveryclient;

import com.sopregistration.databasediscoveryclient.Controllers.Service.HongFahService;
import com.sopregistration.databasediscoveryclient.Controllers.Service.ScoreService;
import com.sopregistration.databasediscoveryclient.Controllers.Service.StudentService;
import com.sopregistration.databasediscoveryclient.Controllers.Service.TeacherService;
import com.sopregistration.databasediscoveryclient.model.HongFah;
import com.sopregistration.databasediscoveryclient.model.Score;
import com.sopregistration.databasediscoveryclient.model.Student;
import com.sopregistration.databasediscoveryclient.model.Teacher;
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
    @Autowired
    TeacherService teacherService;

    public static void main(String[] args) {
        SpringApplication.run(DatabasediscoveryclientApplication.class, args);
    }



    ////////////////////////////////////////////    Student    ////////////////////////////////////////////


    @RequestMapping(value = "user/student/add", method = RequestMethod.POST)
    List<Student> addStudent(@RequestBody List<Student> student){
        Boolean chk;
        for (Student i:student
             ) {
            chk = studentService.createStudent(i);
            if(chk == false){
                List<Student> list = student;
                list.clear();
                return list;
            }
        }
        return studentService.getAllStudent();
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
    String deleteStudentID(@PathVariable int id){ return studentService.deleteStudent(id) ? "Delete Success":"Delete Failed"; }



    ////////////////////////////////////////////    End - Student    ////////////////////////////////////////////




    ////////////////////////////////////////////    Score            ////////////////////////////////////////////


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


    @RequestMapping(value = "user/hongfah/add", method = RequestMethod.POST)
    List<HongFah> addStaffHongFah(@RequestBody List<HongFah> hongFah){
        for (HongFah h:hongFah
             ) {
            hongFahService.createHongfah(h);
        }
        return hongFah;
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
    String deleteHongfahID(@PathVariable int id){ return hongFahService.deleteHongfah(id) ? "Delete Success":"Delete Failed"; }




    ////////////////////////////////////////////    End - HongFah    ////////////////////////////////////////////



    ////////////////////////////////////////////    Teacher           ///////////////////////////////////////////

    @RequestMapping(value = "user/teacher/add", method = RequestMethod.POST)
    List<Teacher> addTeacher(@RequestBody List<Teacher> teachers){
        Boolean chk;
        for (Teacher i: teachers
        ) {
            chk = teacherService.createTeacher(i);
            if(chk == false){
                List<Teacher> list = teachers;
                list.clear();
                return list;
            }
        }
        return teacherService.getAllTeacher();
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
    String deleteTeacherID(@PathVariable int id){ return teacherService.deleteTeacher(id) ? "Delete Success":"Delete Failed"; }


    ////////////////////////////////////////////    End - Teacher    ////////////////////////////////////////////



}
