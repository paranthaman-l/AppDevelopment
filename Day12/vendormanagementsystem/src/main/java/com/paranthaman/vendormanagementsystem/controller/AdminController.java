package com.paranthaman.vendormanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paranthaman.vendormanagementsystem.constant.Api;
import com.paranthaman.vendormanagementsystem.dto.response.AdminDTO;
import com.paranthaman.vendormanagementsystem.service.AdminService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.ADMIN)
@RequiredArgsConstructor
@Tag(name = "Admin")
@CrossOrigin(value = Api.FRONTEND)
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok().body("Hello Admin");
    }

    @GetMapping("/byAid")
    public AdminDTO getAdmin(@RequestParam String aid) {
        return  adminService.getAdmin(aid);
    }
    
    @PutMapping("/approveVendor")
    public ResponseEntity<String> approveVendor(@RequestParam String vid) {
        return ResponseEntity.ok().body(adminService.approveVendor(vid));
    }

    @PutMapping("/approveOrganization")
    public ResponseEntity<String> approveOrganization(@RequestParam String oid) {
        return ResponseEntity.ok().body(adminService.approveOrganization(oid));
    }
}