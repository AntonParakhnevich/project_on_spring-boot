package com.test.mapper;

import com.test.model.AdminModel;
import com.test.model.entity.Admin;
import java.util.List;
import java.util.stream.Collectors;

public class AdminMapper implements Mapper<AdminModel, Admin> {

  @Override
  public AdminModel toModel(Admin entity) {
    return new AdminModel(
        entity.getId(),
        entity.getUserAccountId(),
        entity.getCompanyId()
    );
  }

  @Override
  public List<AdminModel> toModelList(List<Admin> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
