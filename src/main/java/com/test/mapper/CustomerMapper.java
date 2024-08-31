package com.test.mapper;

import com.test.model.CustomerModel;
import com.test.model.entity.Customer;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper implements Mapper<CustomerModel, Customer> {

  @Override
  public CustomerModel toModel(Customer entity) {
    return new CustomerModel(
        entity.getId(),
        entity.getUserAccountId()
    );
  }

  @Override
  public List<CustomerModel> toModelList(List<Customer> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
