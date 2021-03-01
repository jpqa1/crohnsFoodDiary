package com.bae.crohnsFoodDiary.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bae.crohnsFoodDiary.domain.Food;
import com.bae.crohnsFoodDiary.services.FoodService;

public class FoodController {

	private FoodService foodService;

	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}

	@PostMapping("/create")
	public ResponseEntity<Food> createFood(@RequestBody Food food) {
		return new ResponseEntity<Food>(this.foodService.createFood(food), HttpStatus.CREATED);

	}

}
