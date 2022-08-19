package com.example.expensemanager.service;

import com.example.expensemanager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AdminService {

    Logger logger = Logger.getLogger(AdminService.class.getName());

    @Autowired
    private AdminRepository adminRepository;
}
