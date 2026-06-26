package com.meen.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meen.expense_tracker.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
