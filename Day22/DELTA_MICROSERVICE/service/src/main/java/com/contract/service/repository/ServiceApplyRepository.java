package com.contract.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contract.service.model.ServiceApply;
import com.contract.service.model.ServiceRequest;

public interface ServiceApplyRepository extends CrudRepository<ServiceApply,String> {

    List<ServiceApply> findAllByOid(String oid);

    List<ServiceApply> findAllBySid(String sid);
    
}
