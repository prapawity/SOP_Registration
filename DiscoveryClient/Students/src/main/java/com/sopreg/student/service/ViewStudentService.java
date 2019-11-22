package com.sopreg.student.service;

import com.sopreg.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewStudentService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Student getStudent(int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Student > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Student.class, id);
        return restExchange.getBody();
    }
}
