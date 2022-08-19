package com.example.expensemanager.service;

import com.example.expensemanager.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class ExpenseTypeService {

    Logger logger = Logger.getLogger(ExpenseTypeService.class.getName());

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;
}
