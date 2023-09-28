package paranthaman.vendormanagementsystem.repositories;
import org.springframework.data.repository.CrudRepository;

import paranthaman.vendormanagementsystem.models.ContractModel;
public interface ContractRepository  extends CrudRepository<ContractModel,String>{
    
}
