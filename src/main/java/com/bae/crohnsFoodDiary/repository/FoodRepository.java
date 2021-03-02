package com.bae.crohnsFoodDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.crohnsFoodDiary.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
