package com.example.budjet_spring.repositories;

import com.example.budjet_spring.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by .
 */
public interface FamilyRepository extends JpaRepository<Family, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM family f WHERE f.login = ?1 and f.password = ?2")
    Family getLoginAndPassword(String login, String password) throws SQLException;

    Family findByLogin(String login);

}
