package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {
}
