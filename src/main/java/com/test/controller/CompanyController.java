package com.test.controller;

import com.test.model.request.CreateCompanyRequest;
import com.test.service.CompanyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping("/")
  public String create(Model model, @ModelAttribute CreateCompanyRequest request) {
    companyService.create(request.getName(), request.getAddress(), request.getPhone());
    return "admin";
  }
}
