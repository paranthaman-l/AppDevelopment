package com.paranthaman.vendormanagementsystem.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.paranthaman.vendormanagementsystem.model.ContractModel;
public interface ContractRepository  extends CrudRepository<ContractModel,String>{

    List<ContractModel> findAllByContractTitleContainingIgnoreCase(String title);
    
}
