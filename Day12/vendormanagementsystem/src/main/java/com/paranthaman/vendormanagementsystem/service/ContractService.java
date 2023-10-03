package com.paranthaman.vendormanagementsystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paranthaman.vendormanagementsystem.model.ContractModel;
import com.paranthaman.vendormanagementsystem.repository.ContractRepository;

@Service
public class ContractService {
    
    @Autowired
    private ContractRepository contractRepository;

    public ArrayList<ContractModel> getAllContracts() {
        return null;
    }

}
