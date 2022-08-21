package com.example.expensemanager.controller;

import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService service;
    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAll(){
        return service.getAll();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<Expense>> getAllByEmployeeId(@PathVariable("employeeId") int employeeId){
        return service.getAllByEmployeeId(employeeId);
    }

    @GetMapping("/{employeeId}/{typeId}")
    public ResponseEntity<List<Expense>> getAllByEmployeeIdTypeId(@PathVariable("employeeId") int employeeId, @PathVariable("typeId") int typeId){
        return service.getAllByEmployeeIdTypeId(employeeId, typeId);
    }

//    @GetMapping("/{organizationId}")
//    public ResponseEntity<List<Expense>> getAllByOrgId(@PathVariable int organizationId){
//        return service.getAllByOrgId(organizationId);
//    }

//    @GetMapping("/{organizationId}/{EmployeeId}")
//    public ResponseEntity<List<Expense>> getAllByOrgIdEmployeeId(@PathVariable int organizationId, @PathVariable int EmployeeId){
//        return service.getAllByOrgIdEmployeeId(organizationId, EmployeeId);
//    }

    @PostMapping("/create")
    public ResponseEntity<Expense> create(@RequestBody Expense expense){
        return service.create(expense);
    }
}
