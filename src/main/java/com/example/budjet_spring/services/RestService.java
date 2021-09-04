package com.example.budjet_spring.services;

import com.example.budjet_spring.DTO.FamilyDTO;
import com.example.budjet_spring.entity.Family;

import java.util.List;

/**
 * Created by .
 */
public interface RestService {

    List<FamilyDTO> getAllFamily();
}
