package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Role;
import com.example.budjet_spring.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by .
 */
@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public Role getRoleByName(String name){
        return  roleRepository.findByName(name);
    }
}
