package com.test.service;

import com.test.model.CreateUserAccountModel;
import com.test.model.entity.Admin;
import com.test.model.entity.UserAccount;
import com.test.model.request.CreateAdminRequest;
import com.test.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  private final UserAccountService userAccountService;
  private final AdminRepository adminRepository;

  public AdminService(UserAccountService userAccountService, AdminRepository adminRepository) {
    this.userAccountService = userAccountService;
    this.adminRepository = adminRepository;
  }

  public void create(CreateAdminRequest request) {
    CreateUserAccountModel createUserAccountModel = new CreateUserAccountModel(request.getName(), request.getPhone(),
        request.getRole(), request.getPassword(), request.getEmail());
    UserAccount userAccount = userAccountService.create(createUserAccountModel);
    Admin admin = new Admin();
//    admin.setUserAccountId(userAccountId);
    admin.setUserAccount(userAccount);
    admin.setStudioId(request.getStudioId());
    adminRepository.save(admin);
  }
}
