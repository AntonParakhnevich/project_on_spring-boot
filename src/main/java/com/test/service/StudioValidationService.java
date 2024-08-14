package com.test.service;

import com.test.model.entity.Studio;
import com.test.validator.ExistStudioByPhoneAndNameValidator;
import com.test.validator.NameValidator;
import com.test.validator.PhoneFormatValidator;
import org.springframework.stereotype.Service;

@Service
public class StudioValidationService implements ValidationService<Studio> {

  private final ExistStudioByPhoneAndNameValidator existStudioValidator;
  private final NameValidator nameValidator;
  private final PhoneFormatValidator phoneFormatValidator;

  public StudioValidationService(ExistStudioByPhoneAndNameValidator existStudioValidator, NameValidator nameValidator,
      PhoneFormatValidator phoneFormatValidator) {
    this.existStudioValidator = existStudioValidator;
    this.nameValidator = nameValidator;
    this.phoneFormatValidator = phoneFormatValidator;
  }

  @Override
  public String validate(Studio studio) {
    String nameValidateError = nameValidator.validate(studio.getName());
    if (nameValidateError != null) {
      return nameValidateError;
    }
    String phoneFormatValidateError = phoneFormatValidator.validate(studio.getPhone());
    if (phoneFormatValidateError != null) {
      return phoneFormatValidateError;
    }
    String existStudioValidateError = existStudioValidator.validate(studio);
    if (existStudioValidateError != null) {
      return existStudioValidateError;
    }
    return null;
  }
}
