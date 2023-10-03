package com.paranthaman.vendormanagementsystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paranthaman.vendormanagementsystem.constant.Api;
import com.paranthaman.vendormanagementsystem.model.ContractModel;
import com.paranthaman.vendormanagementsystem.service.ContractService;

@RestController
@RequestMapping(Api.CONTRACT)
public class ContractController {
    
    @Autowired
    private ContractService contractService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllContracts(){
        ArrayList<ContractModel> contracts = contractService.getAllContracts();
        return ResponseEntity.ok().body(contracts);
    }
}
