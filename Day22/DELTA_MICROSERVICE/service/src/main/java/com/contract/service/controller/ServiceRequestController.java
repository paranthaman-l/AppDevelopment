package com.contract.service.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.contract.service.model.ServiceApply;
import com.contract.service.model.ServiceRequest;
import com.contract.service.service.ServiceRequestService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
    private final ServiceRequestService serviceRequestService;

    @GetMapping("/welcome")
    public String index() {
        return "Hii Hello Service Request";
    }

    @PostMapping("/addServiceRequest")
    public String postMethodName(@RequestBody ServiceRequest entity) {
        return serviceRequestService.postService(entity);
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
    @GetMapping("/getApplyRequest/{sid}")
    public List<ServiceApply> getApplyRequests(@PathVariable String sid){
        return serviceRequestService.getApplyRequests(sid);
    }

    @PostMapping("/addServiceApply/{sid}")
    public ServiceApply serviceApply(@RequestBody ServiceApply serviceApply,@PathVariable String sid) {

        return serviceRequestService.addServiceApply(sid,serviceApply);
    }

}