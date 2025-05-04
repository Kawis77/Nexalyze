package com.nexalyze.nexalyze.organization.controller;

import com.nexalyze.nexalyze.organization.model.Organization;
import com.nexalyze.nexalyze.organization.model.OrganizationModel;
import com.nexalyze.nexalyze.organization.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid OrganizationModel organizationModel) {

        Organization organization = organizationService.createOrganization(organizationModel);
        if (organization == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was a problem creating the organization.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("The organization has been created.");
    }
}
