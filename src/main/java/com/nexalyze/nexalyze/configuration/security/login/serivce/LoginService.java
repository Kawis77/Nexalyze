package com.nexalyze.nexalyze.configuration.security.login.serivce;

import com.nexalyze.nexalyze.configuration.security.login.model.LoginModel;
import com.nexalyze.nexalyze.organization.model.Organization;
import com.nexalyze.nexalyze.organization.service.OrganizationService;
import com.nexalyze.nexalyze.user.model.OrganizationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationUser organizationUser;
    @Autowired
    UserDetailsService userDetailsService;

    public OrganizationUser login(LoginModel loginModel) {
        Organization organization = organizationService.findByTenantId(loginModel.getTenantId());
        if (organization == null) {
            return null;
        }
        //TODO
        //finish logic for login
        return null;
    }


}
