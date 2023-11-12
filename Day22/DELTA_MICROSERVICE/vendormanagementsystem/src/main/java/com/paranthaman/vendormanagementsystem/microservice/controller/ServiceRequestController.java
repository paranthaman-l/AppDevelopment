package com.paranthaman.vendormanagementsystem.microservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paranthaman.vendormanagementsystem.constant.Api;
import com.paranthaman.vendormanagementsystem.microservice.model.ServiceApply;
import com.paranthaman.vendormanagementsystem.microservice.model.ServiceRequest;
import com.paranthaman.vendormanagementsystem.microservice.service.ServiceRequestService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping({Api.ORGANIZATION,Api.VENDOR})
@CrossOrigin(Api.FRONTEND)
public class ServiceRequestController {

    public final ServiceRequestService serviceRequestService;
    @GetMapping("/welcome")
    public String index(){
        return serviceRequestService.welcome();
    }

    @PostMapping("/addServiceRequest")
    public String postMethodName(@RequestBody ServiceRequest request) {
        return serviceRequestService.postService(request);
    }
    @DeleteMapping("/deleteServiceRequest/{sid}")
    public void deleteMethodName(@PathVariable String sid) {
        serviceRequestService.deleteService(sid);
    }

    @GetMapping("/getServiceRequests/{vid}")
    public List<ServiceRequest> getServiceRequests(@PathVariable String vid){
        return serviceRequestService.getServiceRequests(vid);
    }

    @GetMapping("/getAllServiceRequests")
    public List<ServiceRequest> getAllServiceRequests(){
        return serviceRequestService.getAllServiceRequests();
    }

    @PostMapping("/addServiceApply/{sid}")
      public String serviceApply(@RequestBody ServiceApply serviceApply,@PathVariable String sid) {
        return serviceRequestService.addServiceApply(sid,serviceApply);
    }
}