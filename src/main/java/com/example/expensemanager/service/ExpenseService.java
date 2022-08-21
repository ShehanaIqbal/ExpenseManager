package com.example.expensemanager.service;

import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ExpenseService {

    Logger logger = Logger.getLogger(ExpenseService.class.getName());

    @Autowired
    private ExpenseRepository repository;

    public ResponseEntity<Expense> create(Expense expense) {
        try{
            Expense savedItem = repository.save(expense);
            return new ResponseEntity<>(savedItem, HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "Expense create: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    public ResponseEntity<List<Expense>> getAll() {
        try{
            List<Expense> expenses = new ArrayList<>();
            expenses.addAll(repository.findAll());
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "get All Expenses: " + e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Expense>> getAllByEmployeeId(int EmployeeId) {
        try{
            Optional<List<Expense>> expenses = repository.findByEmployeeId(EmployeeId);
            if (expenses.isPresent()){
                return new ResponseEntity<>(expenses.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Get All Expenses of EmployeeId: " + EmployeeId + e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public ResponseEntity<List<Expense>> getAllByOrgId(int organizationId) {
//        try{
//            Optional<List<Expense>> expenses = repository.findByOrganizationId(organizationId);
//            if (expenses.isPresent()){
//                return new ResponseEntity<>(expenses.get(),HttpStatus.OK);
//            }else{
//                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//            }
//        }catch (Exception e){
//            logger.log(Level.SEVERE, "Get All Expenses of organizationId: " + organizationId + e.getMessage());
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    public ResponseEntity<List<Expense>> getAllByOrgIdEmployeeId(int organizationId, int EmployeeId) {
//        try{
//            Optional<List<Expense>> expenses = repository.findByOrganizationIdAndEmployeeId(organizationId, EmployeeId);
//            if (expenses.isPresent()){
//                return new ResponseEntity<>(expenses.get(),HttpStatus.OK);
//            }else{
//                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//            }
//        }catch (Exception e){
//            logger.log(Level.SEVERE, "Get All Expenses of organizationId: " + organizationId + e.getMessage());
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    public ResponseEntity<List<Expense>> getAllByEmployeeIdTypeId(int EmployeeId, int typeId) {
        try{
            Optional<List<Expense>> expenses = repository.findByEmployeeIdAndOrganizationExpenseTypeId(EmployeeId, typeId);
            if (expenses.isPresent()){
                return new ResponseEntity<>(expenses.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Get All Expenses of EmployeeId: " + EmployeeId + e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
