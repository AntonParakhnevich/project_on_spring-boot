package com.test.repository;

import com.test.model.RoleName;
import com.test.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findFirstByName(RoleName name);
}
