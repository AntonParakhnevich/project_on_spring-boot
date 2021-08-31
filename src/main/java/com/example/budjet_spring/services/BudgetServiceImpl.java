package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Budget;
import com.example.budjet_spring.entity.Year;
import com.example.budjet_spring.repositories.BudgetRepository;
import com.example.budjet_spring.repositories.YearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    private final YearRepository yearRepository;

    @Override
    public void addYear(Integer year, Long idBudget) {
        Budget budget = budgetRepository.getById(idBudget);
        Year newYear = Year.builder()
                .year(year)
                .budget(budget)
                .build();
        budget.addYear(newYear);
        yearRepository.save(newYear);
    }

    @Override
    public Integer getTotalAccumulation(Long idBudget){
        Budget budget = budgetRepository.getById(idBudget);
        return budget.calculationTotalAccumulation();
    }

    @Override
    public Integer calculationAccumulationForTheTime(int years, int income, int cost) {
        return years * 12 * (income - cost);
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
