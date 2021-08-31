package com.example.budjet_spring.services;

import com.example.budjet_spring.entity.Family;
import org.springframework.stereotype.Service;

/**
 * Created by .
 */
@Service
public interface FamilyService {
    Family getByLoginAndPassword(String login, String password);

    void registration(String login, String password);
}
