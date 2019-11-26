package com.teacher.teacher.service;

import com.teacher.teacher.model.Section;
import com.teacher.teacher.model.array.SectionList;
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

    public SectionList getAllSection() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sections" ,instances.get(0).getUri().toString());
        ResponseEntity< SectionList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SectionList.class);
        return restExchange.getBody();
    }

    public Section getSectionByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/section/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Section > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Section.class, id);
        return restExchange.getBody();
    }
}