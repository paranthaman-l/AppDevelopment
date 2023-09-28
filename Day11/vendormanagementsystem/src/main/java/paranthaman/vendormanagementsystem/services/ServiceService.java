package paranthaman.vendormanagementsystem.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paranthaman.vendormanagementsystem.models.ServiceModel;
import paranthaman.vendormanagementsystem.repositories.ServiceRepository;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public ArrayList<ServiceModel> getAllServices() {
        ArrayList<ServiceModel> services = (ArrayList<ServiceModel>) serviceRepository.findAll();
        return services;
    }

    public String addService(ServiceModel serviceModel) {
        serviceModel.setSid(UUID.randomUUID().toString());
        serviceModel.setCreatedAt(LocalDateTime.now());
        serviceModel.setUpdatedAt(LocalDateTime.now());

        serviceRepository.save(serviceModel);
        return "Service Added Successfully";
    }

    public Boolean putService(String sid, ServiceModel serviceModel) {
        Boolean isExists = serviceRepository.findById(sid).isPresent();
        if (!isExists)
            return false;
        ServiceModel storedServiceModel = serviceRepository.findById(sid).get();
        ServiceModel newServiceModel = updateServiceModel(storedServiceModel, serviceModel);
        serviceRepository.save(newServiceModel);
        return true;
    }
    
    public Boolean deleteService(String sid) {
        Boolean isExists = serviceRepository.findById(sid).isPresent();
        if (!isExists)
            return false;
        serviceRepository.deleteById(sid);
        return true;
    }

    public ServiceModel updateServiceModel(ServiceModel storedServiceModel, ServiceModel serviceModel) {
        ServiceModel newServiceModel = new ServiceModel();
        newServiceModel.setSid(storedServiceModel.getSid());
        newServiceModel.setCreatedBy(storedServiceModel.getCreatedBy());
        newServiceModel.setCreatedAt(storedServiceModel.getCreatedAt());
        newServiceModel.setUpdatedAt(LocalDateTime.now());
        newServiceModel.setServiceName(serviceModel.getServiceName());
        newServiceModel.setServiceDescription(serviceModel.getServiceDescription());
        newServiceModel.setServiceType(serviceModel.getServiceType());
        newServiceModel.setServiceOwner(serviceModel.getServiceOwner());
        newServiceModel.setServiceStatus(serviceModel.getServiceStatus());
        newServiceModel.setServiceCost(serviceModel.getServiceCost());
        newServiceModel.setServiceDuration(serviceModel.getServiceDuration());
        newServiceModel.setServiceAvailability(serviceModel.getServiceAvailability());
        return newServiceModel;
    }

}
