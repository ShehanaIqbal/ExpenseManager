package com.example.expensemanager.service;

import com.example.expensemanager.constants.Roles;
import com.example.expensemanager.entity.Employee;
import com.example.expensemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthService implements UserDetailsService {

    Logger logger = Logger.getLogger(UserDetailsService.class.getName());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Optional<Employee> existingUser = employeeRepository.findByName(username);
            if (existingUser.isPresent()) {
                ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority(
                        existingUser.get().getRole() == 1 ? Roles.ROLE_USER : Roles.ROLE_ADMIN
                ));
                return new User(existingUser.get().getName(), existingUser.get().getPassword(), roles);
            } else {
                logger.log(Level.INFO, "No user with this username has been found");
                throw new UsernameNotFoundException("No user with this username has been found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("No user with this username has been found");
        }

    }

}