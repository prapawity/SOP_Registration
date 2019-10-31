package com.sopregistation.servicecrud.service;

import com.sopregistation.servicecrud.model.Array.HongfahList;
import com.sopregistation.servicecrud.model.HongFah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class HongfahService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public HongfahList createHongfahStaff(HongfahList hongfahList){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/user/hongfah/add" ,instances.get(0).getUri().toString());
        HongfahList restExchange = restTemplate.postForObject( serviceUri, hongfahList, HongfahList.class);
        return restExchange;
    }

    public HongfahList getAllHongfah() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/user/hongfah" ,instances.get(0).getUri().toString());
        ResponseEntity< HongfahList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, HongfahList.class);
        return restExchange.getBody();
    }

    public HongFah getHongfahByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/user/hongfah/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< HongFah > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, HongFah.class, id);
        return restExchange.getBody();
    }

    public Boolean deleteHongfahByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/user/hongfah/delete/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }

    public HongFah updateHongfah(HongFah hongFah,String id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/user/hongfah/update/%s" ,instances.get(0).getUri().toString(),id);
        HongFah restExchange = restTemplate.postForObject( serviceUri, hongFah, HongFah.class,id);
        return restExchange;
    }
}
