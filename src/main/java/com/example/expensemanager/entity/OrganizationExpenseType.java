package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data

@Table(name = "organizationExpenseType")
public class OrganizationExpenseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name = "organization_id", nullable = false, referencedColumnName = "id")
    private Organization organization;

    @ManyToOne(targetEntity = ExpenseType.class)
    @JoinColumn(name = "expenseType_id", nullable = false, referencedColumnName = "id")
    private ExpenseType expenseType;

    @Column(name = "maxAmount", nullable = false, columnDefinition = "float default 0 NOT NULL")
    private double maxAmount;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(3000)")
    private String description;

    @OneToMany(targetEntity = Expense.class, mappedBy = "organizationExpenseType",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Expense> expenseSet;
}
