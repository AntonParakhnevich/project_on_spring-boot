package com.example.budjet_spring.services;

import com.example.budjet_spring.DTO.FamilyDTO;
import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by .
 */
@Service
@Transactional
@RequiredArgsConstructor
public class RestServiceImpl implements RestService {

    private final FamilyRepository familyRepository;

    @Override
    public List<FamilyDTO> getAllFamily() {
        return familyRepository.findAll().stream().map(FamilyDTO::convert).collect(Collectors.toList());
    }
}
