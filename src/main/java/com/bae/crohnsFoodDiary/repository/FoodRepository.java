package com.bae.crohnsFoodDiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bae.crohnsFoodDiary.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

	// Spring docs link:
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	@Query(value = "SELECT * FROM food WHERE effect LIKE '%Positive%'", nativeQuery = true)
	List<Food> getFoodsWhereEffectPositive();

	// List<Food> getFoodsWhereEffectNegative();

}
