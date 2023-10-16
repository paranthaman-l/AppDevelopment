package com.contract.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contract.service.model.ServiceRequest;
import com.contract.service.repository.ServiceRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {
    private final ServiceRequestRepository serviceRequestRepository;

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
}
