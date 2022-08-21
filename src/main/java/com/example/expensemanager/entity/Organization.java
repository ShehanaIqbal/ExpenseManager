package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data

@Table(name = "organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) UNIQUE NOT NULL")
    private String name;

    @OneToMany(targetEntity = Employee.class, mappedBy = "organization",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Employee> employees;

    @OneToMany(targetEntity = OrganizationExpenseType.class, mappedBy = "organization",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<OrganizationExpenseType> organizationExpenseTypeSet;
}
