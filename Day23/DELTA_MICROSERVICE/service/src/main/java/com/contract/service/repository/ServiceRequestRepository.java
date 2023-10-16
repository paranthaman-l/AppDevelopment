package com.contract.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contract.service.model.ServiceRequest;

public interface ServiceRequestRepository extends CrudRepository<ServiceRequest,String> {

    List<ServiceRequest> findAllByVid(String vid);
    
}
