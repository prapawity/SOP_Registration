package com.teacher.teacher.service;

import com.teacher.teacher.model.Scores;
import com.teacher.teacher.model.array.ScoresList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ScoreService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public ScoresList createScores(ScoresList scores){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores/create" ,instances.get(0).getUri().toString());
        ScoresList restExchange = restTemplate.postForObject( serviceUri, scores, ScoresList.class);
        return restExchange;
    }

    public Scores updateScores(Scores scores, int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores/update/%d" ,instances.get(0).getUri().toString(),id);
        Scores restExchange = restTemplate.postForObject( serviceUri, scores, Scores.class,id);
        return restExchange;
    }

    public ScoresList getAllScores() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores" ,instances.get(0).getUri().toString());
        ResponseEntity< ScoresList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, ScoresList.class);
        return restExchange.getBody();
    }

    public Scores getScoresByID(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Scores > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Scores.class, id);
        return restExchange.getBody();
    }

    public Boolean deleteScoresByID(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores/delete/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }
}