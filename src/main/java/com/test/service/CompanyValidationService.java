package com.test.service;

import com.test.model.entity.Company;
import com.test.validator.ExistCompanyByPhoneAndNameValidator;
import com.test.validator.NameValidator;
import com.test.validator.PhoneFormatValidator;
import org.springframework.stereotype.Service;

@Service
public class CompanyValidationService implements ValidationService<Company> {

  private final ExistCompanyByPhoneAndNameValidator existCompanyValidator;
  private final NameValidator nameValidator;
  private final PhoneFormatValidator phoneFormatValidator;

  public CompanyValidationService(ExistCompanyByPhoneAndNameValidator existCompanyValidator,
      NameValidator nameValidator,
      PhoneFormatValidator phoneFormatValidator) {
    this.existCompanyValidator = existCompanyValidator;
    this.nameValidator = nameValidator;
    this.phoneFormatValidator = phoneFormatValidator;
  }

  @Override
  public String validate(Company company) {
    String nameValidateError = nameValidator.validate(company.getName());
    if (nameValidateError != null) {
      return nameValidateError;
    }
    String phoneFormatValidateError = phoneFormatValidator.validate(company.getPhone());
    if (phoneFormatValidateError != null) {
      return phoneFormatValidateError;
    }
    String existCompanyValidateError = existCompanyValidator.validate(company);
    if (existCompanyValidateError != null) {
      return existCompanyValidateError;
    }
    return null;
  }
}
