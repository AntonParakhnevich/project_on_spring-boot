package com.test.service;

import com.test.model.CreateUserAccountModel;
import com.test.model.RoleName;
import com.test.model.entity.Customer;
import com.test.model.entity.UserAccount;
import com.test.model.request.CreateCustomerRequest;
import com.test.repository.CustomerRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final UserAccountService userAccountService;

  public CustomerService(CustomerRepository customerRepository, UserAccountService userAccountService) {
    this.customerRepository = customerRepository;
    this.userAccountService = userAccountService;
  }

  @Transactional
  public void create(CreateCustomerRequest request) {
    CreateUserAccountModel createUserAccountModel = new CreateUserAccountModel(request.getName(), request.getPhone(),
        RoleName.USER, request.getPassword(), request.getEmail());
    UserAccount userAccount = userAccountService.create(createUserAccountModel);
    Customer customer = new Customer();
    customer.setUserAccount(userAccount);
    customerRepository.save(customer);
  }
}
