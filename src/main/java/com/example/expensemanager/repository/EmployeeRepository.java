package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    Optional<List<Employee>> findByOrganizationId(int organizationId);

    Optional<Employee> findByName(String username);
}
