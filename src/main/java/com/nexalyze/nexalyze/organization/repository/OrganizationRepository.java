package com.nexalyze.nexalyze.organization.repository;

import com.nexalyze.nexalyze.organization.model.Organization;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization , Long> {

    @Query("SELECT MAX(o.tenantId) FROM Organization o")
    Integer findMaxTenantId();

    Organization findByTenantId(int tenantId);

}
