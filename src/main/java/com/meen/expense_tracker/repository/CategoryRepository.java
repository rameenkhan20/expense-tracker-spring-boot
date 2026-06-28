package com.meen.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meen.expense_tracker.model.Category;

// interface containing methods like save() findById() findAll()

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
