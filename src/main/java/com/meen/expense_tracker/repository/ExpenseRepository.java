package com.meen.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meen.expense_tracker.model.Expense;

import java.time.LocalDate;
import java.util.List;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory_NameAndDateBetween(String name,LocalDate from, LocalDate to);

    List<Expense> findByCategory_Name(String name);
}



//Repository - Interfaces containing methods like save, FindById, Delete basically CRUD operations
//JPARepository - Standard Set for transferring data to the database


/*  JPARepository - a generic base interface that gives you ready-made
CRUD methods, customized to a specific entity type and its ID type via generics.  */