package com.bae.crohnsFoodDiary.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bae.crohnsFoodDiary.domain.Food;
import com.bae.crohnsFoodDiary.repository.FoodRepository;
import com.bae.crohnsFoodDiary.services.FoodServiceDB;

@SpringBootTest
public class FoodServiceDBUnitTest {

	@Autowired // load from the context
	private FoodServiceDB foodService;

	@MockBean // Mocking a food repository
	private FoodRepository repo;

	@Test
	void testCreateFood() {
		// GIVEN
		// Representation of Food object passed as a parameter to createFood(Food food)
		// in foodService
		Food passedFood = new Food("Pork", "Protein", 150, "Positive");

		// Representation of Food which will be returned from createFood(Food food) in
		// foodService, this will be the same as passedFood but it will have an ID.
		Food savedFood = new Food(1l, "Pork", "Protein", 150, "Positive");

		// WHEN - bypassing what would normally happen in the save method
		Mockito.when(this.repo.save(passedFood)).thenReturn(savedFood);

		// THEN
		assertThat(this.foodService.createFood(passedFood)).isEqualTo(savedFood);
	}

	@Test
	void testGetFoods() {

		// Mocking the list which will be returned when calling getFoods()
		Food exampleFood = new Food("Pork", "Protein", 150, "Positive");
		List<Food> returnedList = List.of(exampleFood);

		// WHEN
		Mockito.when(this.foodService.getFoods()).thenReturn(returnedList);

		// THEN
		assertThat(this.foodService.getFoods()).isEqualTo(returnedList);

	}

	@Test
	void testGetFood() {

		// Representation of passed (given) id
		Long id = 1L;

		// FOOD TO BE RETURNED
		Optional<Food> returnedFoodOpt = Optional.of(new Food(id, "Pork", "Protein", 150, "Positive"));

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(returnedFoodOpt);

		// THEN
		assertThat(this.foodService.getFood(id)).isEqualTo(returnedFoodOpt.get());

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	@Test
	void testRemoveFood() {

		Long id = 1L;
		boolean result = false;
		assertThat(this.foodService.removeFood(id)).isEqualTo(result);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

	@Test
	void testUpdateFood() {
		// GIVEN
		// ID
		Long id = 1L;
		// NEW FOOD DATA
		Food newFood = new Food("Pork", "Protein", 150, "Positive");
		// OPTIONAL EXISTING FOOOD
		Optional<Food> optionalFood = Optional.of(new Food(id, "Pizza", "Carbohydrate", 300, "Positive"));
		// UPDATED FOOD
		Food updatedFood = new Food(id, newFood.getName(), newFood.getType(), newFood.getCaloriesPerPortion(),
				newFood.getEffect());

		// /\/\/\ SET UP DATA /\/\/\

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(optionalFood);
		// MAKE SURE THE MOCK INPUT HAS AN equals() METHOD
		Mockito.when(this.repo.save(updatedFood)).thenReturn(updatedFood);

		// THEN
		assertThat(this.foodService.updateFood(id, newFood)).isEqualTo(updatedFood);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedFood);

	}

}
