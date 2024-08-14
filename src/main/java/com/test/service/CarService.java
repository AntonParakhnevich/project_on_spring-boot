package com.test.service;

import com.test.model.entity.Car;
import com.test.repository.CarRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public Long create(String number, Long companyId, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {

    Car car = new Car();
    car.setNumber(number);
    car.setCompanyId(companyId);
    car.setActive(isActive);
    car.setInsuranceDate(insuranceDate);
    car.setTechnicalInspectionDate(technicalInspectionDate);

    return carRepository.save(car).getId();
  }
}
