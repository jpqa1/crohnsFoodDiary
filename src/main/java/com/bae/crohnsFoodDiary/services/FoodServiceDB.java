package com.bae.crohnsFoodDiary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.crohnsFoodDiary.domain.Food;
import com.bae.crohnsFoodDiary.repository.FoodRepository;

@Service
public class FoodServiceDB implements FoodService {

	private FoodRepository foodRepo;

	// in order for spring to build a controller it will need to build a singleton
	// instance of the service first.
	// The service is dependent upon a repository in order to interact (query) the
	// database.
	// Therefore before spring can build a service it will need to first build a
	// singleton instance of the repository.
	// The instance of the controller/service/repository are spring beans and they
	// are stored within the spring context (bean bag)
	public FoodServiceDB(FoodRepository foodRepo) {
		super();
		this.foodRepo = foodRepo;
	}

	@Override
	public Food createFood(Food food) {
		return this.foodRepo.save(food);
	}

	@Override
	public List<Food> getFoods() {
		return this.foodRepo.findAll();
	}

	@Override
	public Food getFood(Long id) {
		Optional<Food> optFood = this.foodRepo.findById(id);
		return optFood.get();
	}

	@Override
	public boolean removeFood(Long id) {
		Food food = this.getFood(id);
		this.foodRepo.delete(food);
		return this.foodRepo.existsById(id);
	}

	@Override
	public Food updateFood(Long id, Food newFood) {
		Food existing = this.getFood(id);
		existing.setName(newFood.getName());
		existing.setType(newFood.getType());
		existing.setCaloriesPerPortion(newFood.getCaloriesPerPortion());
		existing.setEffect(newFood.getEffect());

		Food updatedFood = this.foodRepo.save(existing);
		return updatedFood;
	}

	@Override
	public List<Food> getFoodsWhereEffectPositive() {
		return this.foodRepo.getFoodsWhereEffectPositive();
	}

}
