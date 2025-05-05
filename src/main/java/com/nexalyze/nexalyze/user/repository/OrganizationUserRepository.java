package com.nexalyze.nexalyze.user.repository;

import com.nexalyze.nexalyze.user.model.OrganizationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUserRepository extends JpaRepository<OrganizationUser, Long> {

    OrganizationUser findByUsername(String username);
    OrganizationUser findByEmail(String email);

}
