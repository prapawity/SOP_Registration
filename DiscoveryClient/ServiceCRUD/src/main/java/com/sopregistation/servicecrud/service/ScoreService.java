package com.sopregistation.servicecrud.service;

import com.sopregistation.servicecrud.model.Array.PointList;
import com.sopregistation.servicecrud.model.Array.ScoreList;
import com.sopregistation.servicecrud.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Component
public class ScoreService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public ScoreList createScore(ScoreList score){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/score/add" ,instances.get(0).getUri().toString());
        ScoreList restExchange = restTemplate.postForObject( serviceUri, score, ScoreList.class);
        return restExchange;
    }

    public PointList createPoint(PointList points){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/points/add" ,instances.get(0).getUri().toString());
        PointList restExchange = restTemplate.postForObject( serviceUri, points, PointList.class);
        return restExchange;
    }
}
