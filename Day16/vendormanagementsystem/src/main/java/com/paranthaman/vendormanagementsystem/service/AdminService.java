package com.paranthaman.vendormanagementsystem.service;

import org.springframework.stereotype.Service;

import com.paranthaman.vendormanagementsystem.dto.response.AdminDTO;
import com.paranthaman.vendormanagementsystem.model.Admin;
import com.paranthaman.vendormanagementsystem.model.Organization;
import com.paranthaman.vendormanagementsystem.model.User;
import com.paranthaman.vendormanagementsystem.model.Vendor;
import com.paranthaman.vendormanagementsystem.repository.AdminRepository;
import com.paranthaman.vendormanagementsystem.repository.OrganizationRepository;
import com.paranthaman.vendormanagementsystem.repository.UserRepository;
import com.paranthaman.vendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final VendorRepository vendorRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;


    public AdminDTO getAdmin(String aid) {
        Admin admin = adminRepository.findById(aid).get();
        User user = admin.getUser();
        var adminDTO = AdminDTO.builder().aid(aid).name(user.getName()).email(user.getEmail()).build();
        return adminDTO;
    }

    public String approveVendor(String vid) {
        Vendor vendor = vendorRepository.findById(vid).get();
        vendor.setVerified(true);
        vendorRepository.save(vendor);
        return "Vendor Approved Successfully";
    }
    
    public String approveOrganization(String oid) {
        Organization org = organizationRepository.findById(oid).get();
        org.setVerified(true);
        organizationRepository.save(org);
        return "Organization Approved Successfully";
    }

    public String updateName(String aid, String name) {
        User user = userRepository.findById(aid).get();
        user.setName(name);
        userRepository.save(user);
        return "Update Name Successfully";
    }

}