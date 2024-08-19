package com.test.controller;

import com.test.model.request.CreateCustomerRequest;
import com.test.service.CustomerService;
import com.test.service.UserAccountService;
import com.test.service.UserValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RegistrationController {

  private final UserAccountService userService;
  private final UserValidationService userValidator;
  private final CustomerService customerService;

  public RegistrationController(UserAccountService userService,
      UserValidationService userValidator, CustomerService customerService) {
    this.userService = userService;
    this.userValidator = userValidator;
    this.customerService = customerService;
  }

  @GetMapping("/registration")
  public String registration(Model model, @ModelAttribute("user") CreateCustomerRequest user) {
    model.addAttribute("user", user);
    return "registration";
  }

  @PostMapping("/registration")
  public String registration(@ModelAttribute("userForm") CreateCustomerRequest request,
      BindingResult bindingResult) {
    userValidator.validate(request, bindingResult);

    if (bindingResult.hasErrors()) {
      return "registration";
    }

    customerService.create(request);
//    userService.loadUserByUsername(request.getEmail());

    return "redirect:/login";
  }
}
