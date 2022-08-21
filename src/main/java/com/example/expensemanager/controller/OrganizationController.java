package com.example.expensemanager.controller;


import com.example.expensemanager.entity.Organization;
import com.example.expensemanager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/org")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @PostMapping("/create")
    public ResponseEntity<Organization> create(@RequestBody Organization organization){
        return service.create(organization);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getExpenseTypeById(@PathVariable int id){
        return service.getOrganizationById(id);
    }
}
