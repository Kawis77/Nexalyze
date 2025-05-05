package com.nexalyze.nexalyze.organization.service;

import com.nexalyze.nexalyze.organization.model.Organization;
import com.nexalyze.nexalyze.organization.model.OrganizationModel;
import com.nexalyze.nexalyze.organization.repository.OrganizationRepository;
import com.nexalyze.nexalyze.user.model.OrganizationUser;
import com.nexalyze.nexalyze.user.repository.OrganizationUserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationUserRepository organizationUserRepository;

    public Organization createOrganization(OrganizationModel organizationModel) {

        if (organizationModel == null) {
            return null;
        }

        Organization organization = new Organization();
        organization.setName(organizationModel.getOrganizationName());
        organization.setLicence(organizationModel.getLicense());
        organization.setTenantId(generateUniqueTenant());
        organization = organizationRepository.save(organization);

        if (organization == null) {
            return null;
        }

        OrganizationUser organizationUser = new OrganizationUser();
        organizationUser.setUsername(organizationModel.getUserName());
        organizationUser.setEmail(organizationModel.getEmail());
        organizationUser.setPassword(organizationModel.getPassword());
        organizationUser.setFirstname(organizationModel.getFirstName());
        organizationUser.setSurname(organizationModel.getSurname());
        organizationUser.setOrganizationId(organization.getId());
        organizationUser.setRole("ROLE_ORGANISATION_ADMIN");

        organizationUser = organizationUserRepository.save(organizationUser);

        if (organizationUser == null) {
            return null;
        }

        return organization;
    }

    private Integer generateUniqueTenant() {
        int tenantId = organizationRepository.findMaxTenantId();
        tenantId++;
        Organization organization = organizationRepository.findByTenantId(tenantId);
        while (organization != null) {
            log.debug("generateUniqueTenant[0]: Organization with tenantId : " + tenantId + " already exist.");
            tenantId++;
            organization = organizationRepository.findByTenantId(tenantId);
        }
        return tenantId;
    }

    public Organization findByTenantId(Integer tenantId) {
        Organization organization = null;
        if (tenantId != null && tenantId > 0) {
            organization = organizationRepository.findByTenantId(tenantId);
        } else {
            log.debug("findByTenantId[0]: Problem with getting Organization from db. TenantId is null ");
        }
        return organization;
    }
}
