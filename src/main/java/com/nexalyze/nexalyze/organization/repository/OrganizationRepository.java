package com.nexalyze.nexalyze.organization.repository;

import com.nexalyze.nexalyze.organization.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization , Long> {
}
