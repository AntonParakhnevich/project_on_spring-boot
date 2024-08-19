package com.test.controller;

import com.test.model.entity.Customer;
import com.test.model.entity.UserAccount;
import com.test.service.CustomerService;
import com.test.service.UserAccountService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private-area")
public class PrivateAreaController {

  private final CustomerService customerService;

  public PrivateAreaController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping()
  public String init(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    Customer customer = customerService.getByEmail(userDetails.getUsername());
    model.addAttribute("userName", userDetails.getUsername());
    model.addAttribute("customer", customer);
    return "private-area";
  }
}
