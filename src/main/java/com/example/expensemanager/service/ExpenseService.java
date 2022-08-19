package com.example.expensemanager.service;

import com.example.expensemanager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class ExpenseService {

    Logger logger = Logger.getLogger(ExpenseService.class.getName());

    @Autowired
    private ExpenseRepository expenseRepository;
}
