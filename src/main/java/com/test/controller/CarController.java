package com.test.controller;

import com.test.model.request.CreateCarRequest;
import com.test.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping("/")
  public Long create(@RequestBody CreateCarRequest request) {
    return carService.create(request.getNumber(), request.getCompanyId(), request.getActive(),
        request.getInsuranceDate(), request.getTechnicalInspectionDate());
  }
}
