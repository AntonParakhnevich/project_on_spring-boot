package com.test.mapper;

import com.test.model.UserAccountModel;
import com.test.model.entity.UserAccount;
import java.util.List;
import java.util.stream.Collectors;

public class UserAccountMapper implements Mapper<UserAccountModel, UserAccount> {

  @Override
  public UserAccountModel toModel(UserAccount entity) {
    return new UserAccountModel(
        entity.getId(),
        entity.getName(),
        entity.getEmail(),
        entity.getRole().getName(),
        entity.getPassword(),
        entity.getEmail()
    );
  }

  @Override
  public List<UserAccountModel> toModelList(List<UserAccount> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
