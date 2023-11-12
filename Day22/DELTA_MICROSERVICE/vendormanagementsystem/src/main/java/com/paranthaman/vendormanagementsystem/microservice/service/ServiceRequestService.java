package com.paranthaman.vendormanagementsystem.microservice.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paranthaman.vendormanagementsystem.microservice.model.ServiceApply;
import com.paranthaman.vendormanagementsystem.microservice.model.ServiceRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    final String serviceRequestURL = "http://localhost:8081/api/v1/serviceRequest";

    public String welcome() {
        return restTemplate().getForObject(serviceRequestURL + "/welcome", String.class);
    }

    public String postService(ServiceRequest request) {
        return restTemplate().postForEntity(serviceRequestURL + "/addServiceRequest", request, String.class).getBody();
    }

    public void deleteService(String sid) {
        restTemplate().delete(serviceRequestURL + "/deleteServiceRequest/" + sid);
    }

    public List<ServiceRequest> getServiceRequests(String vid) {
        return restTemplate().exchange(
                serviceRequestURL + "/getServiceRequests/" + vid,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ServiceRequest>>() {
                }).getBody();

    }

    public List<ServiceRequest> getAllServiceRequests() {
        return restTemplate().exchange(
                serviceRequestURL + "/getAllServiceRequests",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ServiceRequest>>() {
                }).getBody();
    }

    public String addServiceApply(String sid, ServiceApply serviceApply) {
        return restTemplate().postForEntity(serviceRequestURL+"/addServiceApply/"+sid, serviceApply, String.class)
                .getBody();
    }

}
