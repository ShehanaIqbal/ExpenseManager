package com.example.expensemanager.service;

import com.example.expensemanager.repository.OrganizationExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class OrganizationExpenseTypeService {

    Logger logger = Logger.getLogger(OrganizationExpenseTypeService.class.getName());

    @Autowired
    private OrganizationExpenseTypeRepository organizationExpenseTypeRepository;
}
