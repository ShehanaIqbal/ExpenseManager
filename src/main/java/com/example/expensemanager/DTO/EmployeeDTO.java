package com.example.expensemanager.DTO;

import javax.persistence.Column;

public class EmployeeDTO {

    private int id;
    private String name;
    private String password;
    private int organizationId;
    private String employeeNo;
    private boolean isActive;

    // admin - 0, employee - 1
    private int role;
}
