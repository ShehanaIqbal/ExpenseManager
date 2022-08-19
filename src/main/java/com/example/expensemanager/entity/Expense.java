package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "Expense")
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "User.id")
    private int userId;

    @JoinColumn(name = "ExpenseType.id")
    private int expenseTypeId;

    @Column(name = "amount", nullable = false, columnDefinition = "float default 0 NOT NULL")
    private double amount;

}
