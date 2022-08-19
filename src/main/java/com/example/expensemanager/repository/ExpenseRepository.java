package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpenseRepository extends
        JpaRepository<Expense, Integer>, JpaSpecificationExecutor<Expense> {
}
