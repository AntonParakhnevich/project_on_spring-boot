package com.example.budjet_spring.controller;

import com.example.budjet_spring.entity.Family;
import com.example.budjet_spring.services.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by .
 */
@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    private final RestService restService;

    @GetMapping ("/allFamily")
    public List<Family> getAllFamily(){
        return restService.getAllFamily();
    }
}
