package com.healteion.HealthionApp.Controller;


import com.healteion.HealthionApp.Dto.FoodDTO;
import com.healteion.HealthionApp.Dto.MemberDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.Entity.Food;
import com.healteion.HealthionApp.Entity.Member;
import com.healteion.HealthionApp.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/food")
public class FoodController {

    @Autowired
    public FoodService foodService;

    @PostMapping("/save/{memberId}")
    public SessionDTO saveMember(@PathVariable int memberId, @RequestBody FoodDTO foodDTO){
        SessionDTO sessionDTO = foodService.addFood(memberId, foodDTO);
        return sessionDTO;
    }

    @GetMapping("/get/{date}/{mid}")
    public List<FoodDTO> getMember(@PathVariable String date, @PathVariable int mid){
        List<FoodDTO> foods = foodService.getFood(date, mid);

        return foods;
    }
}
