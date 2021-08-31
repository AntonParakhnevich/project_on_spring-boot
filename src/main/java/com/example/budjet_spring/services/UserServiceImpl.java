package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.entity.Role;
import com.example.budjet_spring.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by .
 */
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final FamilyRepository familyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Family family = familyRepository.findByLogin(username);
        if (family == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(username, family.getPassword(), generatedAuthorities(family.getRoles()));
    }

    private Collection<? extends GrantedAuthority> generatedAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
