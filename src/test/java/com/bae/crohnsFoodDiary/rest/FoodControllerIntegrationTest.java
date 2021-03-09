package com.bae.crohnsFoodDiary.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.crohnsFoodDiary.domain.Food;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:food-schema.sql",
		"classpath:food-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//@ActiveProfiles("test")
public class FoodControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		// create food
		Food newFood = new Food("Chorizo", "Protein", 100, "Negative");
		// convert it to json string
		String newFoodAsJSON = this.mapper.writeValueAsString(newFood);
		// build mock request
		RequestBuilder mockRequest = post("/createFood").contentType(MediaType.APPLICATION_JSON).content(newFoodAsJSON);

		// create "saved" Food
		Food savedFood = new Food(3L, "Chorizo", "Protein", 100, "Negative");
		// convert "saved" Food to json
		String savedFoodAsJSON = this.mapper.writeValueAsString(savedFood);

		// check status is 201 - CREATED
		ResultMatcher matchStatus = status().isCreated();
		// check that response body is correct User
		ResultMatcher matchBody = content().json(savedFoodAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void readTest() throws Exception {
		Food testFoodOne = new Food(1L, "Spinach", "Vegetable", 10, "Positive");
		Food testFoodTwo = new Food(2L, "Chillies", "Vegetable", 10, "Negative");
		List<Food> allFoods = new ArrayList<Food>();
		allFoods.add(testFoodOne);
		allFoods.add(testFoodTwo);
		String testUserAsJSON = this.mapper.writeValueAsString(allFoods);

		RequestBuilder mockRequest = get("/getFood");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testUserAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void updateTest() throws Exception {

		// create Food
		Food newFood = new Food("Pizza", "Carbohydrate", 300, "Positive");
		// convert it to json string
		String newFoodAsJSON = this.mapper.writeValueAsString(newFood);
		// build mock request
		RequestBuilder mockRequest = put("/updateFood/1").contentType(MediaType.APPLICATION_JSON)
				.content(newFoodAsJSON);
		// create "updated" Food
		Food updatedFood = new Food(1L, "Pizza", "Carbohydrate", 300, "Positive");
		// convert "updated" Food to json
		String updatedFoodAsJSON = this.mapper.writeValueAsString(updatedFood);
		// check status is 201 - CREATED
		ResultMatcher matchStatus = status().isOk();
		// check that response body is correct User
		ResultMatcher matchBody = content().json(updatedFoodAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void deleteTest() throws Exception {

		RequestBuilder mockRequest = delete("/removeFood/1");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("false");
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getPositiveFoodTest() throws Exception {
		// create Food (WHAT YOU EXPECT THE TEST TO RETURN)
		Food testFoodPos = new Food(1L, "Spinach", "Vegetable", 10, "Positive");
		// create List (WHAT YOU EXPECT THE TEST TO RETURN)
		List<Food> positiveFoods = List.of(testFoodPos);

		String testUserAsJSON = this.mapper.writeValueAsString(positiveFoods);

		RequestBuilder mockRequest = get("/getPositiveFood");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testUserAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void getNegativeFoodTest() throws Exception {

		// create Food (WHAT YOU EXPECT THE TEST TO RETURN)
		Food testFoodNeg = new Food(2L, "Chillies", "Vegetable", 10, "Negative");
		// create List (WHAT YOU EXPECT THE TEST TO RETURN)
		List<Food> positiveFoods = List.of(testFoodNeg);

		String testUserAsJSON = this.mapper.writeValueAsString(positiveFoods);

		RequestBuilder mockRequest = get("/getNegativeFood");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testUserAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}

}
