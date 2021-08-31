package com.example.budjet_spring.services;

/**
 * Created by .
 */
public interface CategoryCostService {
    void addCategoryCost(String nameCategory, Integer amount,Integer binding,Long idMonth);

    void deleteCategoryCost(Long idIncome);
}

