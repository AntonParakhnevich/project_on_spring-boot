package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Budget;
import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.entity.Role;
import com.example.budjet_spring.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository familyRepository;
    private final PasswordEncoder passwordEncoder;

    public Family getByLoginAndPassword(String login, String password) {
        Family family = null;
        try {
            family = familyRepository.getLoginAndPassword(login, passwordEncoder.encode(password));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return family;
    }

    public void registration(String login, String password) {
        Budget budget = Budget.builder().build();
        Family family = Family.builder()
                .login(login)
                .password(passwordEncoder.encode(password))
                .budget(budget)
                .build();
        family.addRole("user");
        budget.setFamily(family);
        familyRepository.save(family);
    }

    public Family findByLogin(String login){
        return familyRepository.findByLogin(login);
    }

    public List<Family> findAll(){
        return  familyRepository.findAll();
    }

}
