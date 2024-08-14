package com.test.service;

import com.test.model.CreateUserAccountModel;
import com.test.model.entity.Role;
import com.test.model.entity.UserAccount;
import com.test.repository.RoleRepository;
import com.test.repository.UserAccountRepository;
import java.util.Collections;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAccountService implements UserDetailsService {

  private final UserAccountRepository userAccountRepository;
  private final RoleRepository roleRepository;
  private final UserAccountValidationService userAccountValidationService;
  private final PasswordEncoder passwordEncoder;

  public UserAccountService(UserAccountRepository repository,
      RoleRepository roleRepository, UserAccountValidationService userAccountValidationService,
      PasswordEncoder passwordEncoder) {
    this.userAccountRepository = repository;
    this.roleRepository = roleRepository;
    this.userAccountValidationService = userAccountValidationService;
    this.passwordEncoder = passwordEncoder;
  }

  public UserAccount create(CreateUserAccountModel model) {
    Role role = roleRepository.findFirstByName(model.getRole());

    UserAccount userAccount = new UserAccount();
    userAccount.setName(model.getName());
    userAccount.setPhone(model.getPhone());
    userAccount.setRole(role);
    userAccount.setPassword(passwordEncoder.encode(model.getPassword()));
    userAccount.setEmail(model.getEmail());
    userAccount.setRoleId(role.getId());

    String validateErrorMessage = userAccountValidationService.validate(userAccount);
    if (validateErrorMessage != null) {
      throw new IllegalArgumentException(validateErrorMessage);
    }

    return userAccountRepository.save(userAccount);
  }

  public UserAccount getById(Long id) {
    return userAccountRepository.findById(id)
        .orElse(null);
  }

  public UserAccount getByName(String name) {
    return userAccountRepository.findByName(name);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return Optional.ofNullable(userAccountRepository.findByName(username))
        .map(userAccount -> new User(userAccount.getEmail(), userAccount.getPassword(),
            Collections.singletonList(userAccount.getRole().getName())))
        .orElseThrow(() -> new IllegalArgumentException("user not found"));
  }
}
