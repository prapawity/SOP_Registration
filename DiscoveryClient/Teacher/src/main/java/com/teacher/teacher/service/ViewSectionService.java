package com.teacher.teacher.service;

import com.teacher.teacher.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewSectionService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Section getSubject(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/subject/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Section > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Section.class, id);
        return restExchange.getBody();
    }
}