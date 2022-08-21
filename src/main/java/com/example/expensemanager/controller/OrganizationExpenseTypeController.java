package com.example.expensemanager.controller;

import com.example.expensemanager.entity.OrganizationExpenseType;
import com.example.expensemanager.service.OrganizationExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orgExpenseType")
public class OrganizationExpenseTypeController {

    @Autowired
    private OrganizationExpenseTypeService service;

    @PostMapping("/create")
    public ResponseEntity<OrganizationExpenseType> create
            (@RequestBody OrganizationExpenseType organizationExpenseType){
        return service.create(organizationExpenseType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationExpenseType> getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<List<OrganizationExpenseType>> getByOrganizationId(@PathVariable("orgId") int orgId){
        return service.getByOrganizationId(orgId);
    }
}
