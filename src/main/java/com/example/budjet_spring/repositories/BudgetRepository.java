package com.example.budjet_spring.repositories;

import com.example.budjet_spring.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by .
 */
public interface BudgetRepository extends JpaRepository<Budget,Long> {

}
