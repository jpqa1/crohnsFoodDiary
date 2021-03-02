package com.bae.crohnsFoodDiary.services;

import java.util.List;

import com.bae.crohnsFoodDiary.domain.Food;

public class FoodServiceList implements FoodService {

	private List<Food> foodList; // dependency

	public FoodServiceList(List<Food> foodList) {
		super();
		this.foodList = foodList;
	}

	@Override
	public Food createFood(Food food) {
		this.foodList.add(food);
		Food foodAdded = foodList.get(foodList.size() - 1);
		return foodAdded;
	}

	@Override
	public Food removeFood(int id) {
		return this.foodList.remove(id);
	}

	@Override
	public List<Food> getFoods() {
		return this.foodList;
	}

	@Override
	public Food getFood(int id) {
		return this.foodList.get(id);
	}

	@Override
	public Food updateFood(int id, Food food) {
		Food foodToUpdate = getFood(id);
		foodToUpdate.setName(food.getName());
		foodToUpdate.setType(food.getType());
		foodToUpdate.setCaloriesPerPortion(food.getCaloriesPerPortion());
		foodToUpdate.setEffect(food.getEffect());
		return foodToUpdate;

	}

}
