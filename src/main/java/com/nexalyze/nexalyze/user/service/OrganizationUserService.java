package com.nexalyze.nexalyze.user.service;

import com.nexalyze.nexalyze.user.model.OrganizationUser;
import com.nexalyze.nexalyze.user.repository.OrganizationUserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class OrganizationUserService {
    @Autowired
    private OrganizationUserRepository organizationUserRepository;

    public OrganizationUser getByUsername(String username) {
        if (StringUtils.isNotEmpty(username)) {
            OrganizationUser organizationUser = organizationUserRepository.findByUsername(username);
            if (organizationUser == null) {
                log.debug("getByUsername[0]: Problem with getting user. User witt username : " + username + " doesn't exist");
            }
            return organizationUser;
        }
        log.debug("getByUsername[1]: Problem with getting user. The given username is empty or null");
        return null;
    }

    public OrganizationUser getUserByEmail(String email) {
        if (StringUtils.isNotEmpty(email)) {
            OrganizationUser organizationUser = organizationUserRepository.findByEmail(email);
            if (organizationUser == null) {
                log.debug("getUserByEmail[0]: Problem with getting user. User with email : " + email + " doesn't exist");
            }
            return organizationUser;
        }
        log.debug("getUserByEmail[1]: Problem with getting user. The given email is empty or null");
        return null;
    }



}
