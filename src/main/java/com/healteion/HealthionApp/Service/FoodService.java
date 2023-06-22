package com.healteion.HealthionApp.Service;

import com.healteion.HealthionApp.Dto.FoodDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.Entity.Member;

import java.util.List;

public interface FoodService {
    SessionDTO addFood(int memberId, FoodDTO foodDTO);

    List<FoodDTO> getFood(String date, int mid);
}
