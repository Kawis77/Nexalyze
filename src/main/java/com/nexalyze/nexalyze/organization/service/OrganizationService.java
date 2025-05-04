package com.nexalyze.nexalyze.organization.service;

import com.nexalyze.nexalyze.organization.model.Organization;
import com.nexalyze.nexalyze.organization.model.OrganizationModel;
import com.nexalyze.nexalyze.organization.repository.OrganizationRepository;
import com.nexalyze.nexalyze.user.model.OrganizationUser;
import com.nexalyze.nexalyze.user.repository.OrganizationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
