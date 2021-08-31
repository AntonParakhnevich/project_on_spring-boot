package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.CategoryCost;
import com.example.budjet_spring.entity.Expenses;
import com.example.budjet_spring.entity.Month;
import com.example.budjet_spring.repositories.CategoryCostRepository;
import com.example.budjet_spring.repositories.MonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class CategoryCostServiceImpl implements CategoryCostService {

    private final MonthRepository monthRepository;
    private final CategoryCostRepository categoryCostRepository;

    @Override
    public void addCategoryCost(String nameCategory, Integer amount,Integer binding, Long idMonth) {
        Month month = monthRepository.getById(idMonth);
        CategoryCost categoryCost = CategoryCost.builder()
                .name(nameCategory)
                .price(amount)
                .expenses(month.getExpenses())
                .binding(binding)
                .build();
        Expenses expenses = monthRepository.getById(idMonth).getExpenses();
        expenses.addCategory(categoryCost);
        categoryCostRepository.save(categoryCost);
    }

    @Override
    public void deleteCategoryCost(Long idIncome) {
        categoryCostRepository.deleteById(idIncome);
    }
}
