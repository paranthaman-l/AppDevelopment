package paranthaman.vendormanagementsystem.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paranthaman.vendormanagementsystem.models.ContractModel;
import paranthaman.vendormanagementsystem.models.ServiceModel;
import paranthaman.vendormanagementsystem.services.ContractService;

@RestController
@RequestMapping("/contract")
public class ContractController {
    
    @Autowired
    private ContractService contractService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllContracts(){
        ArrayList<ContractModel> contracts = contractService.getAllContracts();
        return ResponseEntity.ok().body(contracts);
    }
}
