package com.paranthaman.vendormanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paranthaman.vendormanagementsystem.constant.Api;
import com.paranthaman.vendormanagementsystem.dto.request.LoginDTO;
import com.paranthaman.vendormanagementsystem.dto.request.SignUpDTO;
import com.paranthaman.vendormanagementsystem.dto.request.TokenDTO;
import com.paranthaman.vendormanagementsystem.dto.response.AuthenticationResponse;
import com.paranthaman.vendormanagementsystem.model.Organization;
import com.paranthaman.vendormanagementsystem.model.Vendor;
import com.paranthaman.vendormanagementsystem.service.AuthService;
import com.paranthaman.vendormanagementsystem.service.OrganizationService;
import com.paranthaman.vendormanagementsystem.service.VendorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.AUTH)
@RequiredArgsConstructor
@CrossOrigin(value = Api.FRONTEND)
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthService authService;
    private final VendorService vendorService;
    private final OrganizationService organizationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpDTO request) {
        return authService.userRegistration(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginDTO request) {
        return ResponseEntity.ok(authService.userAuthentication(request));
    }

    @PostMapping("/byToken")
    public ResponseEntity<AuthenticationResponse> authenticateByToken(@RequestBody TokenDTO tokenDTO) {
        return ResponseEntity.ok(authService.userAuthenticationByToken(tokenDTO));
    }

      @PutMapping("/vendor/update/{vid}")
    public ResponseEntity<?> updateVendor(@RequestBody Vendor vendor,@PathVariable String vid){
        return vendorService.updateVendor(vid,vendor);
    }
      @PutMapping("/organization/update/{oid}")
    public ResponseEntity<?> updateOrganization(@RequestBody Organization organization,@PathVariable String oid){
        return organizationService.updateOrganization(oid,organization);
    }

    @GetMapping("/byOid/{oid}")
    public Organization getOrganization(@PathVariable String oid){
        return organizationService.getOrganization(oid);
    }
    @GetMapping("/byVid/{vid}")
    public Vendor getVendor(@PathVariable String vid){
        return vendorService.getVendor(vid);
    }

}
