package com.nexalyze.nexalyze.configuration.security.login.serivce;

import com.nexalyze.nexalyze.configuration.security.login.model.LoginModel;
import com.nexalyze.nexalyze.configuration.security.login.model.TokenResponse;
import com.nexalyze.nexalyze.organization.model.Organization;
import com.nexalyze.nexalyze.organization.service.OrganizationService;
import com.nexalyze.nexalyze.user.model.OrganizationUser;
import com.nexalyze.nexalyze.user.service.OrganizationUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LoginService {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationUserService organizationUserService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;


    public TokenResponse login(LoginModel loginModel) {
        TokenResponse tokenResponse = new TokenResponse();
        Organization organization = organizationService.findByTenantId(loginModel.getTenantId());
        if (organization == null) {
            tokenResponse.setMessage("Organization doesn't exist in system");
            log.debug("login[0]: Can't login in and create a auth token , organization is null");
            return null;
        }

        OrganizationUser organizationUser = organizationUserService.getByUsernameAndOrganizationId(loginModel.getUsername(), organization.getId());
        if (organizationUser == null) {
            tokenResponse.setMessage("User doesn't exist in this organization.");
            log.debug("login[1]: Can't login in and create a auth token , organization user doesn't exist in organization with id: " + organization.getId() );
            return null;
        }

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginModel.getUsername(), loginModel.getPassword()));

        if (authentication == null){
            tokenResponse.setMessage("Authorization failed.");
            log.debug("login[2]: Authorization failed. The login details you provided are incorrect." );
            return null;
        }

        String token = jwtService.generateToken(authentication);
        tokenResponse.setToken(token);

        return tokenResponse;
    }
}
