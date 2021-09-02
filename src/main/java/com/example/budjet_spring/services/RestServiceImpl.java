package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by .
 */
@Service
@Transactional
@RequiredArgsConstructor
public class RestServiceImpl implements RestService{

    private final FamilyRepository familyRepository;

    @Override
    public List<Family> getAllFamily() {
        System.out.println(familyRepository.findAll());
        return familyRepository.findAll();
    }
}
