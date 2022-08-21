package com.example.expensemanager.controller;

import com.example.expensemanager.entity.ExpenseType;
import com.example.expensemanager.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/expenseType")
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService service;

    @PostMapping("/create")
    public ResponseEntity<ExpenseType> create(@RequestBody ExpenseType expenseType){
        return service.create(expenseType);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseType> getExpenseTypeById(@PathVariable int id){
        return service.getExpenseTypeById(id);
    }
}
