package paranthaman.vendormanagementsystem.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paranthaman.vendormanagementsystem.models.ContractModel;
import paranthaman.vendormanagementsystem.repositories.ContractRepository;

@Service
public class ContractService {
    
    @Autowired
    private ContractRepository contractRepository;

    public ArrayList<ContractModel> getAllContracts() {
        return null;
    }

}
