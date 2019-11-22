package com.sop.hongfah.service;

import com.sop.hongfah.model.Array.TeacherList;
import com.sop.hongfah.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TeacherService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public TeacherList createTeacher(TeacherList teachers){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/teacher/create" ,instances.get(0).getUri().toString());
        TeacherList restExchange = restTemplate.postForObject( serviceUri, teachers, TeacherList.class);
        return restExchange;
    }

    public TeacherList getAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/teachers" ,instances.get(0).getUri().toString());
        ResponseEntity< TeacherList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, TeacherList.class);
        return restExchange.getBody();
    }

    public Teacher getTeacherByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/teacher/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Teacher > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Teacher.class, id);
        return restExchange.getBody();
    }

    public Boolean deleteTeacherByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%steacher/delete/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }

    public Teacher updateTeacher(Teacher teacher,String id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/teacher/update/%s" ,instances.get(0).getUri().toString(),id);
        Teacher restExchange = restTemplate.postForObject( serviceUri, teacher, Teacher.class,id);
        return restExchange;
    }
}
