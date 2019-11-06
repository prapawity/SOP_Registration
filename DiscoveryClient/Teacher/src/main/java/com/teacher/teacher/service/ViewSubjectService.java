package com.teacher.teacher.service;

import com.teacher.teacher.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewSubjectService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Subject getSubject(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/subject/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Subject > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Subject.class, id);
        return restExchange.getBody();
    }
}
