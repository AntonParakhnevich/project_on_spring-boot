package com.test.validator;

import com.test.model.entity.Studio;
import com.test.repository.StudioRepository;
import org.springframework.stereotype.Service;

@Service
public class ExistStudioByPhoneAndNameValidator implements Validator<Studio> {

  private final StudioRepository studioRepository;

  public ExistStudioByPhoneAndNameValidator(StudioRepository studioRepository) {
    this.studioRepository = studioRepository;
  }

  @Override
  public String validate(Studio studio) {
    Integer countByPhone = studioRepository.countByPhoneAndName(studio.getPhone(), studio.getName());
    if (countByPhone > 0) {
      return "Студия с данным номером и именем уже зарегистрирована";
    }
    return null;
  }
}
