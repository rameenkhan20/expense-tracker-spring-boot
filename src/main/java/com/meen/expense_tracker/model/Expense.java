package com.meen.expense_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Amount is Required!")
    @Positive(message = "Amount must be greater than 0!")
    private BigDecimal amount;

    @NotBlank(message = "Description can't be blank!")
    private String description;

    @NotNull(message = "Date is Required!")
    private LocalDate date;

    @NotBlank(message = "Payment method is Required!")
    private String paymentMethod;

    @NotNull(message = "Category is Required!")
    @ManyToOne                      // many expense can fall under one category
    @JoinColumn(name = "category_id")    // foreign key name
    private Category category;
}
