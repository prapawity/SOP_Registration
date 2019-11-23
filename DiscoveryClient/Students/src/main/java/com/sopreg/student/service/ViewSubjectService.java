package com.sopreg.student.service;

import com.sopreg.student.model.*;
import com.sopreg.student.model.array.SubjectList;
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

    public SubjectList getAllSubject() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/subject" ,instances.get(0).getUri().toString());
        ResponseEntity< SubjectList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SubjectList.class);
        return restExchange.getBody();
    }
}
