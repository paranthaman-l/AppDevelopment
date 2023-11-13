package com.contract.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contract.service.model.ServiceApply;
import com.contract.service.model.ServiceRequest;
import com.contract.service.repository.ServiceApplyRepository;
import com.contract.service.repository.ServiceRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {
    private final ServiceRequestRepository serviceRequestRepository;
    private final ServiceApplyRepository serviceApplyRepository;

    public String postService(ServiceRequest request) {
        try {
            serviceRequestRepository.save(request);
            return "Service Added Successfully";
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public void deleteService(String sid) {
        try {
            serviceRequestRepository.deleteById(sid);
        } catch (Exception e) {
        }
    }

    public List<ServiceRequest> getServiceRequests(String vid) {
        return serviceRequestRepository.findAllByVid(vid);
    }

    public List<ServiceRequest> getAllServiceRequests() {
        return (List<ServiceRequest>) serviceRequestRepository.findAll();
    }

    public ServiceApply addServiceApply(String sid,ServiceApply serviceApply) {
        // serviceApply.setServiceRequest(serviceRequestRepository.findById(sid).get());
        return serviceApplyRepository.save(serviceApply);
    }

    public List<ServiceApply> getApplyRequests(String sid) {
        return serviceApplyRepository.findAllBySid(sid);
    }
}
