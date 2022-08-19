package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "ExpenseType")
public class ExpenseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "type", nullable = false, columnDefinition = "varchar(100) UNIQUE NOT NULL")
    private String type;
}
