package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrganizationRepository extends
        JpaRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {
}
