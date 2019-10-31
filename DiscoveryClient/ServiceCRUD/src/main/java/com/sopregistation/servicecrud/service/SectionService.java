package com.sopregistation.servicecrud.service;

import com.sopregistation.servicecrud.model.Array.SectionList;
import com.sopregistation.servicecrud.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SectionService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public SectionList createSection(SectionList sectionList){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/section/add" ,instances.get(0).getUri().toString());
        SectionList restExchange = restTemplate.postForObject( serviceUri, sectionList, SectionList.class);
        return restExchange;
    }

    public SectionList getAllSection() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/section" ,instances.get(0).getUri().toString());
        ResponseEntity< SectionList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, SectionList.class);
        return restExchange.getBody();
    }

    public Section getSectionByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/section/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Section > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Section.class, id);
        return restExchange.getBody();
    }

    public Boolean deleteSectionByID(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/section/delete/%s" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Boolean > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Boolean.class, id);
        return restExchange.getBody();
    }

    public Section updateSectionByID(Section section,String id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("database");
        String serviceUri = String.format("%s/section/update/%s" ,instances.get(0).getUri().toString(),id);
        Section restExchange = restTemplate.postForObject( serviceUri, section, Section.class,id);
        return restExchange;
    }
}
