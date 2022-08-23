package com.example.expensemanager.controller;


import com.example.expensemanager.constants.Roles;
import com.example.expensemanager.entity.Employee;
import com.example.expensemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/all")
    @Secured({Roles.ROLE_USER})
    public ResponseEntity<List<Employee>> getAll(){
        return service.getAll();
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<List<Employee>> getAllByOrg(@PathVariable int orgId){
        return service.getAllByOrg(orgId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }

}
