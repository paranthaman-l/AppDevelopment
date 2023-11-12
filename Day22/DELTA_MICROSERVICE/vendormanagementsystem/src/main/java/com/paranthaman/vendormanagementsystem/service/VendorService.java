package com.paranthaman.vendormanagementsystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paranthaman.vendormanagementsystem.dto.request.AddService;
import com.paranthaman.vendormanagementsystem.dto.request.UpdateImageDTO;
import com.paranthaman.vendormanagementsystem.dto.response.EmployeeDTO;
import com.paranthaman.vendormanagementsystem.model.CertificationModel;
import com.paranthaman.vendormanagementsystem.model.Employee;
import com.paranthaman.vendormanagementsystem.model.ServiceModel;
import com.paranthaman.vendormanagementsystem.model.Vendor;
import com.paranthaman.vendormanagementsystem.repository.CertificateRepository;
import com.paranthaman.vendormanagementsystem.repository.EmployeeRepository;
import com.paranthaman.vendormanagementsystem.repository.ServiceRepository;
import com.paranthaman.vendormanagementsystem.repository.VendorRepository;

import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final ServiceRepository serviceRepository;
    private final EmployeeRepository employeeRepository;
    private final CertificateRepository certificateRepository;

    public Vendor getVendor(String vid) {
        Vendor vendor = vendorRepository.findById(vid).get();
        return vendor;
    }

    public String updateBanner(UpdateImageDTO updateImageDTO) throws IOException {
        try {
            Vendor vendor = vendorRepository.findById(updateImageDTO.getId()).get();
            vendor.setBanner(updateImageDTO.getFile());
            vendorRepository.save(vendor);
            return "Update Profile Successfully";
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public String updateProfile(UpdateImageDTO updateImageDTO) throws IOException {
        try {
            Vendor vendor = vendorRepository.findById(updateImageDTO.getId()).get();
            vendor.setProfile(updateImageDTO.getFile());
            vendorRepository.save(vendor);
            return "Update Profile Successfully";
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public String addService(AddService addService) {
        try {
            ServiceModel service = serviceRepository.findById(addService.getSid()).get();
            Vendor vendor = vendorRepository.findById(addService.getVid()).get();
            List<ServiceModel> services = vendor.getServices();
            services.add(service);
            vendor.setServices(services);
            vendorRepository.save(vendor);
            return "Service Added Successfully";
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public String addEmployee(Employee employee, String sid, String vid) {
        try {
            employee.setVendor(vendorRepository.findById(vid).get());
            employee.setServiceModel(serviceRepository.findById(sid).get());
            employeeRepository.save(employee);
            return "Employee Added Successfully";
        } catch (Exception e) {

            return "Something went wrong!";
        }
    }

    public List<Employee> getAllEmployee(String vid) {
        try {
            List<Employee> employees = vendorRepository.findById(vid).get().getEmployees();
            return employees;
        } catch (Exception e) {

            return null;
        }
    }

    public Object getAllCertificates(String vid) {
        try {
            return  vendorRepository.findById(vid).get().getCertificates();
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public Object addCertificate(String vid, CertificationModel certificationModel) {
         try {
            certificationModel.setVendor(vendorRepository.findById(vid).get());
            return certificateRepository.save(certificationModel);
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }
    public Object deleteCertificate(String certificateId) {
         try {
            certificateRepository.deleteById(certificateId);
            return "Deleted Successfully!";
        } catch (Exception e) {
            return "Something went wrong!";
        }
    }

    public ResponseEntity<?>  updateVendor(String vid,Vendor vendor) {
                Optional<Vendor> existingEntityOptional = vendorRepository.findById(vid);

        if (existingEntityOptional.isPresent()) {
            Vendor existingEntity = existingEntityOptional.get();

            // Step 2: Use BeanUtils to copy non-null properties from updatedEntity to existingEntity
            BeanUtils.copyProperties(vendor, existingEntity, getNullPropertyNames(vendor));

            // Step 3: Save the updated entity back to the database
            Vendor savedEntity = vendorRepository.save(existingEntity);

            return new ResponseEntity<>(savedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
