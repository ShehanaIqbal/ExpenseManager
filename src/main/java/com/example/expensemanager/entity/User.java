package com.example.expensemanager.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @JoinColumn(name = "organization.id")
    private int organizationId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employeeNo", nullable = false, columnDefinition = "varchar(10) UNIQUE")
    private String employeeNo;

    @Column(name = "isActive", nullable = false, columnDefinition = "boolean default false")
    private boolean isActive;
}
