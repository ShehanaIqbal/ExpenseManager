package com.example.expensemanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data

@Table(name = "expenseType")
public class ExpenseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "type", nullable = false, columnDefinition = "varchar(100) UNIQUE NOT NULL")
    private String type;

    @OneToMany(targetEntity = OrganizationExpenseType.class, mappedBy = "expenseType",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<OrganizationExpenseType> organizationExpenseTypeSet;
}
