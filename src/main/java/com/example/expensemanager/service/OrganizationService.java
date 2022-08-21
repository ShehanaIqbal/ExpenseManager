package com.example.expensemanager.service;

import com.example.expensemanager.entity.Organization;
import com.example.expensemanager.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrganizationService {

    Logger logger = Logger.getLogger(OrganizationService.class.getName());

    @Autowired
    private OrganizationRepository repository;

    public ResponseEntity<Organization> create(Organization organization) {
        try {
            Organization savedItem = repository.save(organization);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Organization create: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Organization> getOrganizationById(int id) {
        try{
            Optional<Organization> organization = repository.findById(id);
            if (organization.isPresent()){
                return new ResponseEntity<>(organization.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Organization get with Id : "+ id + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
