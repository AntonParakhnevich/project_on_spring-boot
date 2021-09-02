package com.example.budjet_spring.controller;

import com.example.budjet_spring.entity.Budget;
import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.services.BudgetServiceImpl;
import com.example.budjet_spring.services.FamilyServiceImpl;
import com.example.budjet_spring.services.YearServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.YearMonth;
import java.util.List;

/**
 * Created by .
 */
@Controller
@RequiredArgsConstructor
@SessionAttributes("family")
public class BudgetController {

    private final BudgetServiceImpl budgetService;
    private final YearServiceImpl yearService;
    private  final FamilyServiceImpl familyService;

    @GetMapping("/createYear")
    public ModelAndView addYearGet(ModelAndView modelAndView) {

        modelAndView.addObject("maxYear", YearMonth.now().getYear());
        modelAndView.setViewName("createYear");
        return modelAndView;
    }

    @PostMapping("/createYear")
    public String addYearPost(@RequestParam Integer year,
                              @ModelAttribute("family") Family fam) {
        budgetService.addYear(year, fam.getBudget().getId());
        return "redirect:/index";
    }

    @GetMapping("/index")
    public ModelAndView getIndex(@ModelAttribute("family") Family family,
                                 ModelAndView modelAndView) {
        Budget budget = family.getBudget();
        System.out.println(budget.getId());
        modelAndView.addObject("totalAccumulation",budgetService.getTotalAccumulation(budget.getId()));
        modelAndView.addObject("years", yearService.getAllYear(family.getBudget().getId()));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        budgetService.logout(httpSession);
        return "redirect:/start";
    }

    @GetMapping("calculate")
    public String getCalculate() {
        return "calculate";
    }

    @PostMapping("calculate")
    public ModelAndView postCalculate(@RequestParam int years,
                                      @RequestParam int income,
                                      @RequestParam int cost,
                                      ModelAndView modelAndView) {
        Integer accumulation = budgetService.calculationAccumulationForTheTime(years, income, cost);
        modelAndView.addObject("years", years);
        modelAndView.addObject("income", income);
        modelAndView.addObject("cost", cost);
        modelAndView.addObject("accumulation", accumulation);
        modelAndView.setViewName("resultCalculate");
        return modelAndView;
    }

//    @GetMapping ("/allFamily")
//    public ModelAndView getAllFamily(ModelAndView modelAndView){
//        List<Family> all = familyService.findAll();
//        modelAndView.addObject("AllFamily",familyService.findAll());
//        modelAndView.setViewName("/allFamily");
//        return modelAndView;
//    }
}
