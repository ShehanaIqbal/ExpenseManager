package com.example.expensemanager.service;

import com.example.expensemanager.entity.ExpenseType;
import com.example.expensemanager.entity.OrganizationExpenseType;
import com.example.expensemanager.entity.Employee;
import com.example.expensemanager.repository.OrganizationExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrganizationExpenseTypeService {

    Logger logger = Logger.getLogger(OrganizationExpenseTypeService.class.getName());

    @Autowired
    private OrganizationExpenseTypeRepository repository;

    public ResponseEntity<OrganizationExpenseType> create(
            OrganizationExpenseType organizationExpenseType) {
        try{
            OrganizationExpenseType savedItem = repository.save(organizationExpenseType);
            return new ResponseEntity<>(savedItem, HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "OrganizationExpenseType create : "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<OrganizationExpenseType> getById(int id) {
        try{
            Optional<OrganizationExpenseType> organizationExpenseType = repository.findById(id);
            if (organizationExpenseType.isPresent()){
                return new ResponseEntity<>(organizationExpenseType.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Employee get by id: " + id + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<OrganizationExpenseType>> getByOrganizationId(int orgId) {
        try{
            Optional<List<OrganizationExpenseType>> organizationExpenseTypes = repository.findByOrganizationId(orgId);
            if (organizationExpenseTypes.isPresent()){
                return new ResponseEntity<>(organizationExpenseTypes.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Employee getAll by orgId: " +orgId + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
