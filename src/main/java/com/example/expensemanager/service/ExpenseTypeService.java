package com.example.expensemanager.service;

import com.example.expensemanager.entity.ExpenseType;
import com.example.expensemanager.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ExpenseTypeService {

    Logger logger = Logger.getLogger(ExpenseTypeService.class.getName());

    @Autowired
    private ExpenseTypeRepository repository;

    public ResponseEntity<ExpenseType> create(ExpenseType expenseType) {
        try{
            ExpenseType savedItem = repository.save(expenseType);
            return new ResponseEntity<>(savedItem,HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "Exception Type create: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<ExpenseType> getExpenseTypeById(int id) {
        try{
            Optional<ExpenseType> expenseType = repository.findById(id);
            if (expenseType.isPresent()){
                return new ResponseEntity<>(expenseType.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Get Expense Type with Id : "+ id + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
