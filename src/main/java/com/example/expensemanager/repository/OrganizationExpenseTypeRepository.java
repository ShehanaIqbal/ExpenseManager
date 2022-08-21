package com.example.expensemanager.repository;

import com.example.expensemanager.entity.OrganizationExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface OrganizationExpenseTypeRepository extends
        JpaRepository<OrganizationExpenseType, Integer>, JpaSpecificationExecutor<OrganizationExpenseType> {
    Optional<List<OrganizationExpenseType>> findByOrganizationId(int orgId);
}
