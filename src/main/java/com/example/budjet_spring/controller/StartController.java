package com.example.budjet_spring.controller;

import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.entity.Role;
import com.example.budjet_spring.services.FamilyServiceImpl;
import com.example.budjet_spring.services.YearServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by .
 */

@Controller
@RequiredArgsConstructor
@SessionAttributes("family")
public class StartController {

    private final FamilyServiceImpl familyService;
    private final YearServiceImpl yearService;

    @GetMapping({"/start","/"})
    public String start() {
        return "start";
    }

    @ModelAttribute("family")
    public Family addFamily() {
        return new Family();
    }

    @GetMapping("/startProgram")
    public ModelAndView getStartProgram(@ModelAttribute("family") Family fam,
                                        ModelAndView modelAndView) {
        fam = familyService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        List<String> namesRole = fam.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

        modelAndView.addObject("family", fam);
        modelAndView.addObject("roles", namesRole);
        modelAndView.addObject("years", yearService.getAllYear(fam.getBudget().getId()));
        modelAndView.setViewName("index");
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(String::valueOf)
                .forEach(fam::addRole);
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String postRegistration(@RequestParam(required = false) String login,
                                   @RequestParam(required = false) String password) {
        familyService.registration(login, password);
        return "redirect:/start";
    }

}
