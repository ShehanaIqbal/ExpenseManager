package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "Admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @JoinColumn(name = "organization.id")
    private int organizationId;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) UNIQUE NOT NULL")
    private String name;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(100) UNIQUE NOT NULL")
    private String password;

    @Column(name = "isActive", nullable = false, columnDefinition = "boolean default false")
    private boolean isActive;

}
