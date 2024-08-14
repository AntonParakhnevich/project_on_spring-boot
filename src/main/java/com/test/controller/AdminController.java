package com.test.controller;

import com.test.model.RoleName;
import com.test.model.request.CreateAdminRequest;
import com.test.model.request.CreateCompanyRequest;
import com.test.service.AdminService;
import com.test.service.CompanyService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;
  private final CompanyService companyService;

  public AdminController(AdminService adminService, CompanyService companyService) {
    this.adminService = adminService;
    this.companyService = companyService;
  }

  @GetMapping
  public String init(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    model.addAttribute("userName", userDetails.getUsername());
    return "admin";
  }

  @GetMapping(value = "/create")
  public String initCreate(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    List<RoleName> roles = new ArrayList<>();
    roles.add(RoleName.ADMIN);
    if (userDetails.getAuthorities().contains(RoleName.SUPER_ADMIN)) {
      roles.add(RoleName.SUPER_ADMIN);
    }
    model.addAttribute("admin", new CreateAdminRequest());
    model.addAttribute("roles", roles);
    model.addAttribute("companies", companyService.getAll());
    return "create-admin";
  }

  @GetMapping(value = "/create-company")
  public String initCreateCompany(Model model) {
    model.addAttribute("company", new CreateCompanyRequest());
    return "create-company";
  }

  @PostMapping("/")
  public String create(Model model, @ModelAttribute CreateAdminRequest request,
      @AuthenticationPrincipal UserDetails userDetails) {
    model.addAttribute("userName", userDetails.getUsername());
    model.addAttribute("company", new CreateCompanyRequest());
    model.addAttribute("admin", new CreateAdminRequest());
    model.addAttribute("roles", Arrays.asList(RoleName.ADMIN, RoleName.SUPER_ADMIN));
    adminService.create(request);
    return "admin";
  }
}
