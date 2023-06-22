package com.healteion.HealthionApp.Dto;

import com.healteion.HealthionApp.Entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {

    private int memberId;
    private String name;
    private String email;
    private String password;

    private List<Food> foods;


}
