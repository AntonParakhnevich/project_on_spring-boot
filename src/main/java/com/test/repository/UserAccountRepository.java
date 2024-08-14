package com.test.repository;

import com.test.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

  Integer countByPhone(String phone);

  UserAccount findByName(String name);
}
