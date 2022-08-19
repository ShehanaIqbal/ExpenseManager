package com.example.expensemanager.service;

import com.example.expensemanager.entity.User;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> create(User user) {
        try {
            User savedItem = userRepository.save(user);
            return new ResponseEntity<>(removePassword(savedItem), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "User create: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> users = new ArrayList<User>();
            users.addAll(userRepository.findAll());
            return new ResponseEntity<>(removePassword(users), HttpStatus.OK);
        }catch (Exception e){
            logger.log(Level.SEVERE, "User getAll: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> getUserById(int id){
        try{
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()){
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "User getAll: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<User>> getAllByOrg(int orgId) {
        try{
            Optional<List<User>> users = userRepository.findByOrganizationId(orgId);
            if (users.isPresent()){
                return new ResponseEntity<>(users.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private User removePassword(User obj) {
        obj.setPassword("");
        return obj;
    }

    private List<User> removePassword(List<User> list) {
        for (User obj : list) {
            obj.setPassword("");
        }
        return list;
    }
}
