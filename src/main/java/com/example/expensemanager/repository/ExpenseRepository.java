package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends
        JpaRepository<Expense, Integer>, JpaSpecificationExecutor<Expense> {
    Optional<List<Expense>> findByEmployeeId(int employeeId);

//    Optional<List<Expense>> findByOrganizationId(int organizationId);

    Optional<List<Expense>> findByEmployeeIdAndOrganizationExpenseTypeId(int employeeId, int typeId);

//    Optional<List<Expense>> findByOrganizationIdAndEmployeeId(int organizationId, int EmployeeId);
}
