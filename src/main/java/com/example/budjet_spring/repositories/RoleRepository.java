package com.example.budjet_spring.repositories;

import com.example.budjet_spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by .
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
