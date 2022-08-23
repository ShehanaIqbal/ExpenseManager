package com.example.expensemanager.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data

@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

//    @ManyToOne(targetEntity = Organization.class)
//    @JoinColumn(name = "organization_id", nullable = false, referencedColumnName = "id")
//    private Organization organization;

    @Column(name = "organization_id", nullable = false)
    private int organizationId;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(1000)")
    private String name;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(1000)")
    private String password;

    @Column(name = "employeeNo", nullable = false, columnDefinition = "varchar(10) UNIQUE")
    private String employeeNo;

    @Column(name = "isActive", nullable = false, columnDefinition = "boolean default false")
    private boolean isActive;

    // admin - 0, employee - 1
    @Column(name = "role", nullable = false, columnDefinition = "integer default 1")
    private int role;

//    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Expense> expenseSet;
}
