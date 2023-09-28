package paranthaman.vendormanagementsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import paranthaman.vendormanagementsystem.models.ServiceModel;

public interface ServiceRepository extends CrudRepository<ServiceModel,String> {
    
}
