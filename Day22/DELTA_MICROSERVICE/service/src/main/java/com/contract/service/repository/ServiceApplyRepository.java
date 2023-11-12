package com.contract.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contract.service.model.ServiceApply;

public interface ServiceApplyRepository extends CrudRepository<ServiceApply,String> {

    List<ServiceApply> findAllByOid(String oid);
    
}
