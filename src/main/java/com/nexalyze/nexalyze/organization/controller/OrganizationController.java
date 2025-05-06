package com.nexalyze.nexalyze.organization.controller;

import com.nexalyze.nexalyze.configuration.json.JsonObject;
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
    public ResponseEntity<JsonObject> create(@RequestBody @Valid OrganizationModel organizationModel) {

        JsonObject response = new JsonObject();
        Organization organization = organizationService.createOrganization(organizationModel);
        if (organization == null) {
            response.addError("There was a problem creating the organization.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        response.addMessage("The organization has been created.");
        response.addId(organization.getTenantId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
