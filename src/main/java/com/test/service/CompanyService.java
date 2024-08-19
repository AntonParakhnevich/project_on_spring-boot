package com.test.service;

import com.test.model.entity.Admin;
import com.test.model.entity.Company;
import com.test.repository.CompanyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final CompanyValidationService companyValidationService;

  public CompanyService(CompanyRepository companyRepository, CompanyValidationService companyValidationService) {
    this.companyRepository = companyRepository;
    this.companyValidationService = companyValidationService;
  }

  public String create(String name, String address, String phone) {
    Company company = new Company();
    company.setName(name);
    company.setPhone(phone);
    company.setAddress(address);

    String validateErrorMessage = companyValidationService.validate(company);
    if (validateErrorMessage != null) {
      return validateErrorMessage;
    }

    companyRepository.save(company);
    return "success";
  }

  public Company getById(Long id) {
    return companyRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Company with id=" + id + " not found"));
  }

  public List<Company> getAll() {
    return companyRepository.findAll();
  }
}
