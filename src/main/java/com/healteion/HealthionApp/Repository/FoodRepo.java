package com.healteion.HealthionApp.Repository;

import com.healteion.HealthionApp.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {
    List<Food> findAllByDateAndMid(String date, int mid);
}
