package com.test.service;

import com.test.mapper.CompanyMapper;
import com.test.model.CompanyModel;
import com.test.model.entity.Company;
import com.test.repository.CompanyRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final CompanyValidationService companyValidationService;
  private final CompanyMapper companyMapper;

  public CompanyService(CompanyRepository companyRepository, CompanyValidationService companyValidationService,
      CompanyMapper companyMapper) {
    this.companyRepository = companyRepository;
    this.companyValidationService = companyValidationService;
    this.companyMapper = companyMapper;
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

  public CompanyModel getById(Long id) {
    return companyRepository.findById(id)
        .map(companyMapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("Company with id=" + id + " not found"));
  }

  public List<CompanyModel> getAll() {
    return companyMapper.toModelList(companyRepository.findAll());
  }
}
