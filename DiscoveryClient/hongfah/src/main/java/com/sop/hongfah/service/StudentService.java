package com.sop.hongfah.service;

import com.sop.hongfah.model.Array.StudentList;
import com.sop.hongfah.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class StudentService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public StudentList createStudent(StudentList student){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/create" ,instances.get(0).getUri().toString());
        StudentList restExchange = restTemplate.postForObject( serviceUri, student, StudentList.class);
        return restExchange;
    }

    public Student updateStudent(Student student, int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/update/%d" ,instances.get(0).getUri().toString(), id);
        Student restExchange = restTemplate.postForObject( serviceUri, student, Student.class,id);
        return restExchange;
    }

    public StudentList getAllStudent() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student" ,instances.get(0).getUri().toString());
        ResponseEntity< StudentList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, StudentList.class);
        return restExchange.getBody();
    }

    public Student getStudentByID(int studentId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/%d" ,instances.get(0).getUri().toString(), studentId);
        ResponseEntity< Student > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Student.class, studentId);
        return restExchange.getBody();
    }

    public Boolean deleteStudentByID(int studentId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/delete/%d" ,instances.get(0).getUri().toString(), studentId);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, studentId);
        return restExchange.getBody();
    }

}
