package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@Table(name = "expense")
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_id", nullable = false)
    private int employeeId;

//    @ManyToOne(targetEntity = Employee.class)
//    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
//    private Employee employee;

    @ManyToOne(targetEntity = OrganizationExpenseType.class)
    @JoinColumn(name = "organizationExpenseType_id", nullable = false, referencedColumnName = "id")
    private OrganizationExpenseType organizationExpenseType;

    @Column(name = "amount", nullable = false, columnDefinition = "float default 0 NOT NULL")
    private double amount;

    @Column(name = "isAccepted", nullable = false, columnDefinition = "boolean default false")
    private boolean isAccepted;

    @Column(name = "isPaid", nullable = false, columnDefinition = "boolean default false")
    private boolean isPaid;
}
