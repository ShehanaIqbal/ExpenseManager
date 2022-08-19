package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "OrganizationExpenseType")
public class OrganizationExpenseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "Organization.id")
    private int organizationId;

    @JoinColumn(name = "ExpenseType.id")
    private int expenseTypeId;

    @Column(name = "maxAmount", nullable = false, columnDefinition = "float default 0 NOT NULL")
    private double maxAmount;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(3000)")
    private String description;
}
