package com.test.controller;

import com.test.model.request.CreateStudioRequest;
import com.test.service.StudioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class StudioController {

  private final StudioService studioService;

  public StudioController(StudioService studioService) {
    this.studioService = studioService;
  }

  @PostMapping("/")
  public String create(Model model, @ModelAttribute CreateStudioRequest request,
      @AuthenticationPrincipal UserDetails userDetails) {
    studioService.create(request.getName(), request.getAddress(), request.getPhone());
    return "admin";
  }
}
