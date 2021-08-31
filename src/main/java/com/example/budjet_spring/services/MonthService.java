package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.CategoryCost;
import com.example.budjet_spring.entity.CategoryIncome;

import java.util.List;

/**
 * Created by .
 */
public interface MonthService {
    List<CategoryIncome> getAllCategoryIncome(Long idMonth);

    List<CategoryCost> getAllCategoryCost(Long idMonth);
}
