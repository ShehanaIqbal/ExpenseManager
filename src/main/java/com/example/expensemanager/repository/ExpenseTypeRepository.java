package com.example.expensemanager.repository;

import com.example.expensemanager.entity.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpenseTypeRepository extends
        JpaRepository<ExpenseType, Integer>, JpaSpecificationExecutor<ExpenseType> {
}
