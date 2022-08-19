package com.example.expensemanager.controller;


import com.example.expensemanager.entity.User;
import com.example.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<List<User>> getAllByOrg(@PathVariable int orgId){
        return userService.getAllByOrg(orgId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return userService.create(user);
    }
}
