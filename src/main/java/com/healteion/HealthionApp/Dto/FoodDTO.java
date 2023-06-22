package com.healteion.HealthionApp.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FoodDTO {

    private int id;
    private String name;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private String date;

}
