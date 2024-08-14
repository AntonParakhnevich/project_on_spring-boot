package com.test.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private-area")
public class PrivateAreaController {

  @GetMapping()
  public String init(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    model.addAttribute("userName", userDetails.getUsername());
    return "private-area";
  }
}
