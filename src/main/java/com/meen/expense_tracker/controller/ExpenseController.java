package com.meen.expense_tracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.meen.expense_tracker.model.Expense;
import com.meen.expense_tracker.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("expenses")

public class ExpenseController {
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return expenseRepository.save(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense(
        @RequestParam (required = false) String category,
        @RequestParam (required = false) LocalDate to,
        @RequestParam (required = false) LocalDate from){
            if(category != null && to != null && from != null){
                return expenseRepository.findByCategory_NameAndDateBetween(category, from, to);
            }
            else if(category != null){
                return expenseRepository.findByCategory_Name(category);
            }
            else{
                return expenseRepository.findAll();
            }
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseRepository.findById(id).orElse(null);
    }

    // @GetMapping("category")
    // public Expense getExpenseByCategory(@RequestParam String category){
    //     return expenseRepository
    // }

    @PutMapping("/{id}")
    public Expense UpdateExpense(@PathVariable Long id, @RequestBody Expense entity) {
        var expenseToBeUpdate = expenseRepository.findById(id).orElse(null);

        expenseToBeUpdate.setAmount(entity.getAmount());
        expenseToBeUpdate.setCategory(entity.getCategory());
        expenseToBeUpdate.setDate(entity.getDate());
        expenseToBeUpdate.setDescription(entity.getDescription());
        expenseToBeUpdate.setPaymentMethod(entity.getPaymentMethod());

        return expenseRepository.save(expenseToBeUpdate);
    }

    @DeleteMapping("/{id}")
    public void removExpense(@PathVariable Long id){
        expenseRepository.deleteById(id);
    }
}
