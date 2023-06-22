package com.healteion.HealthionApp.Service.Impl;

import com.healteion.HealthionApp.Dto.FoodDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.Entity.Food;
import com.healteion.HealthionApp.Entity.Member;
import com.healteion.HealthionApp.Repository.FoodRepo;
import com.healteion.HealthionApp.Repository.MemberRepo;
import com.healteion.HealthionApp.Service.FoodService;
import com.healteion.HealthionApp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoodImpl implements FoodService {

    FoodRepo foodRepo;

    MemberRepo memberRepo;

    public FoodImpl(FoodRepo foodRepo, MemberRepo memberRepo) {
        this.foodRepo = foodRepo;
        this.memberRepo = memberRepo;
    }

    @Override
    public SessionDTO addFood(int memberId, FoodDTO foodDTO) {

        Member member = memberRepo.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member", "id", memberId));

        Food food = new Food(foodDTO.getId(),
                foodDTO.getName(),
                foodDTO.getCalories(),
                foodDTO.getProtein(),
                foodDTO.getCarbs(),
                foodDTO.getFat(),
                foodDTO.getDate(),
                memberId);
        Food resultFood = foodRepo.save(food);

        return new SessionDTO(memberId, member.getName(), member.getEmail());
    }

    @Override
    public List<FoodDTO> getFood(String date, int mid) {

        List<Food> foods = foodRepo.findAllByDateAndMid(date, mid);

        return foods.stream().map(food -> mapToDTO(food)).collect(Collectors.toList());
    }

    private FoodDTO mapToDTO(Food food) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setName(food.getFoodName());
        foodDTO.setCalories(food.getCalories());
        foodDTO.setProtein(food.getProtein());
        foodDTO.setCarbs(food.getCarbs());
        foodDTO.setFat(food.getFat());
        foodDTO.setDate(food.getDate());
        return foodDTO;
    }


}
