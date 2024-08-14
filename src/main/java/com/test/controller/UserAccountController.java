package com.test.controller;

import com.test.model.entity.UserAccount;
import com.test.service.UserAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

  private final UserAccountService userAccountService;

  public UserAccountController(UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

//  @PostMapping("/")
//  public String create(@RequestBody CreateAdminRequest request) {
//    return userAccountService.create(request.getName(), request.getPhone(), request.getRole(), request.getPassword());
//  }

  @GetMapping("/{id}")
  public UserAccount getById(@PathVariable("id") Long id) {
    return userAccountService.getById(id);
  }
}
