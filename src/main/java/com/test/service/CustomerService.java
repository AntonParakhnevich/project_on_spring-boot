package com.test.service;

import com.test.mapper.CustomerMapper;
import com.test.model.CreateUserAccountModel;
import com.test.model.CustomerModel;
import com.test.model.RoleName;
import com.test.model.entity.Customer;
import com.test.model.entity.UserAccount;
import com.test.model.request.CreateCustomerRequest;
import com.test.repository.CustomerRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final UserAccountService userAccountService;
  private final CustomerMapper customerMapper;

  public CustomerService(CustomerRepository customerRepository, UserAccountService userAccountService,
      CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.userAccountService = userAccountService;
    this.customerMapper = customerMapper;
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

  public CustomerModel getByEmail(String email) {
    return Optional.ofNullable(customerRepository.findByEmail(email))
        .map(customerMapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("Customer with email=" + email + " not found"));
  }

//  public Customer getById(Long id) {
//    return customerRepository.findById(id)
//        .orElseThrow(() -> new IllegalArgumentException("Customer with id=" + id + " not found"));
//  }

  @Transactional
  public void delete(CustomerModel customer) {
    customerRepository.deleteById(customer.getId());
    userAccountService.deleteById(customer.getUserAccountId());
  }
}
