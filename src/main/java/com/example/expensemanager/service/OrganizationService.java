package com.example.expensemanager.service;

import com.example.expensemanager.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class OrganizationService {

    Logger logger = Logger.getLogger(OrganizationService.class.getName());

    @Autowired
    private OrganizationRepository organizationRepository;
}
