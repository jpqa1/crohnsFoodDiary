package com.bae.crohnsFoodDiary.services;

import java.util.List;

import com.bae.crohnsFoodDiary.domain.Food;

public interface FoodService {

	// Create a Food Item
	Food createFood(Food food);

	// View all food Items (Read)
	List<Food> getFoods();

	// View a Particular food item by passing ID
	// Used to Update Food Item
	Food getFood(Long id);

	// Delete a Food Item
	boolean removeFood(Long id);

	// Update a Food Item
	Food updateFood(Long id, Food food);

}
