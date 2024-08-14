package com.test.repository;

import com.test.model.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

  Integer countByPhoneAndName(String phone, String name);
}
