package com.sopregistation.servicecrud.service;

import com.sopregistation.servicecrud.model.Array.SubjectList;
import com.sopregistation.servicecrud.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class SubjectService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Subject createSubject(Subject subject){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/subject/add" ,instances.get(0).getUri().toString());
        Subject restExchange = restTemplate.postForObject( serviceUri, subject, Subject.class);
        return restExchange;
    }

    public SubjectList getAllSubject() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/subject" ,instances.get(0).getUri().toString());
        ResponseEntity< SubjectList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SubjectList.class);
        return restExchange.getBody();
    }

    public Subject getSubjectByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/subject/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Subject > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Subject.class, id);
        return restExchange.getBody();
    }

    public Subject updateSubject(Subject subject, String id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/subject/update/%s" ,instances.get(0).getUri().toString(),id);
        Subject restExchange = restTemplate.postForObject( serviceUri, subject, Subject.class,id);
        return restExchange;
    }

    public Boolean deleteSubjectByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/subject/delete/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }

}
