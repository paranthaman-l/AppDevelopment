package com.paranthaman.vendormanagementsystem.service;

import org.springframework.stereotype.Service;

import com.paranthaman.vendormanagementsystem.model.Vendor;
import com.paranthaman.vendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public Vendor getVendor(String vid) {
        Vendor vendor = vendorRepository.findById(vid).get();
        return vendor;

    }
}
