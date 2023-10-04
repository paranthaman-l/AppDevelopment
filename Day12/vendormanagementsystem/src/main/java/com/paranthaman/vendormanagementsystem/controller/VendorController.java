package com.paranthaman.vendormanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paranthaman.vendormanagementsystem.constant.Api;
import com.paranthaman.vendormanagementsystem.model.Vendor;
import com.paranthaman.vendormanagementsystem.service.VendorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.VENDOR)
@RequiredArgsConstructor
@Tag(name = "Vendor")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok().body("Hello Vendor");
    }

    @GetMapping("/byVid")
    public Vendor getVendor(@RequestParam String vid) {
        return vendorService.getVendor(vid);
    }

}
