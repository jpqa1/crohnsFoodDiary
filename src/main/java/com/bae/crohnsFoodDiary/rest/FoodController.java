package com.bae.crohnsFoodDiary.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.crohnsFoodDiary.domain.Food;
import com.bae.crohnsFoodDiary.services.FoodService;

@RestController

public class FoodController {

	// The controller is dependent on a service in order to interact with the
	// repository.
	private FoodService foodService; // dependency

	// Spring injects the food service into the controller (dependency injection)..
	// upon spring bean creation of controller and stores the singleton instance of
	// the controller in the context.
	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}

	@PostMapping("/createFood")
	public ResponseEntity<Food> createFood(@RequestBody Food food) {
		return new ResponseEntity<Food>(this.foodService.createFood(food), HttpStatus.CREATED);
	}

	// get foods
	@GetMapping("/getFood")
	public ResponseEntity<List<Food>> getFood() {
		return new ResponseEntity<List<Food>>(this.foodService.getFoods(), HttpStatus.OK);
	}

	// get food by id
	@GetMapping("getFoodById/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
		return new ResponseEntity<Food>(this.foodService.getFood(id), HttpStatus.OK);
	}

	// update food
	@PutMapping("updateFood/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
		return new ResponseEntity<Food>(this.foodService.updateFood(id, food), HttpStatus.OK);
	}

	// delete food
	@DeleteMapping("removeFood/{id}")
	public boolean removeFood(@PathVariable Long id) {
		return this.foodService.removeFood(id);
	}

	@GetMapping("/getPositiveFood")
	public List<Food> getPositiveFood() {
		return this.foodService.getFoodsWhereEffectPositive();
	}

	@GetMapping("/getNegativeFood")
	public List<Food> getNegativeFood() {
		return this.foodService.getFoodsWhereEffectNegative();
	}

}
