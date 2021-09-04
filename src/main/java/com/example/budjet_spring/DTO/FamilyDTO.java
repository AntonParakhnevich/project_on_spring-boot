package com.example.budjet_spring.DTO;

import com.example.budjet_spring.entity.Family;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by .
 */
@Builder
@ToString
@Getter
@Setter
public class FamilyDTO implements Serializable {
    private String login;
    private Long id;

    public static FamilyDTO convert(Family family) {
        return FamilyDTO
                .builder()
                .login(family.getLogin())
                .id(family.getId())
                .build();
    }
}
