package com.teacher.teacher.service;

import com.teacher.teacher.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewScoreService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Score getScore(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicestudent");
        String serviceUri = String.format("%s/score/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Score > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Score.class, id);
        return restExchange.getBody();
    }
}
