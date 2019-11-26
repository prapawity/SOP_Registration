package com.teacher.teacher.service;

import com.teacher.teacher.model.SectionChecked;
import com.teacher.teacher.model.array.SectionCheckArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SectionCheckerService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public SectionCheckArray createSection(SectionCheckArray sectionCheckArray){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sectionCheck/create" ,instances.get(0).getUri().toString());
        SectionCheckArray restExchange = restTemplate.postForObject( serviceUri, sectionCheckArray, SectionCheckArray.class);
        return restExchange;
    }
    public SectionChecked updateSectionCheck(SectionChecked section, int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sectionCheck/update/%d" ,instances.get(0).getUri().toString());
        SectionChecked restExchange = restTemplate.postForObject( serviceUri, section, SectionChecked.class,id);
        return restExchange;
    }


    public SectionCheckArray getAllSectionCheck() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sectionCheck" ,instances.get(0).getUri().toString());
        ResponseEntity< SectionCheckArray > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SectionCheckArray.class);
        return restExchange.getBody();
    }
    public SectionChecked getSectionChecktByID(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sectionCheck/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity<SectionChecked> restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SectionChecked.class, id);
        return restExchange.getBody();
    }

    public Boolean deleteSectionCheckByID(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/sectionCheck/delete/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }
}

