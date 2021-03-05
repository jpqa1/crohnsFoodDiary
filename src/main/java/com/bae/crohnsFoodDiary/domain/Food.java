package com.bae.crohnsFoodDiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String type;
	private double caloriesPerPortion;
	private String effect;

	public Food(Long id, String name, String type, double caloriesPerPortion, String effect) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.caloriesPerPortion = caloriesPerPortion;
		this.effect = effect;
	}

	public Food() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCaloriesPerPortion() {
		return caloriesPerPortion;
	}

	public void setCaloriesPerPortion(double caloriesPerPortion) {
		this.caloriesPerPortion = caloriesPerPortion;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", type=" + type + ", caloriesPerPortion=" + caloriesPerPortion
				+ ", effect=" + effect + "]";
	}

}