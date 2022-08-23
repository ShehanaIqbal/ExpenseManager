package com.example.expensemanager.service;

import com.example.expensemanager.DTO.EmployeeDTO;
import com.example.expensemanager.entity.Employee;
import com.example.expensemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeService {

    Logger logger = Logger.getLogger(EmployeeService.class.getName());

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<Employee> create(Employee Employee) {
        try {
            Employee savedItem = repository.save(Employee);
            return new ResponseEntity<>(removePassword(savedItem), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Employee create: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Employee>> getAll() {
        try {
            List<Employee> employees = repository.findAll();
            return new ResponseEntity<>(removePassword(employees), HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "Employee getAll: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> getEmployeeById(int id){
        try{
            Optional<Employee> employee = repository.findById(id);
            if (employee.isPresent()){
                return new ResponseEntity<>(employee.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Employee get by id: " + id + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Employee>> getAllByOrg(int orgId) {
        try{
            Optional<List<Employee>> Employees = repository.findByOrganizationId(orgId);
            if (Employees.isPresent()){
                return new ResponseEntity<>(Employees.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Employee getAll by orgId: " +orgId + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Employee removePassword(Employee obj) {
        obj.setPassword("");
        return obj;
    }

    private List<Employee> removePassword(List<Employee> list) {
        for (Employee obj : list) {
            obj.setPassword("");
        }
        return list;
    }

    public ResponseEntity<Employee> update(Integer id, Employee employee) {
        try {
            Optional<Employee> existingItemOptional = repository.findById(id);
            if (existingItemOptional.isPresent()) {
                Employee existingItem = existingItemOptional.get();
//                MapperUtils.merge(existingItem, item);
                return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Employee update: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<HttpStatus> deleteById(int id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Employee deleteById: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
