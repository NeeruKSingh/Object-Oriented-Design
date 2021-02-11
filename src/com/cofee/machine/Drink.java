package com.cofee.machine;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Drink {

	// An extensible design wouldn't use an enum, but the problem specification
	// allows such hard-coding. These entries must be in alphabetical order.
	CAFFE_AMERICANO("Caffè Americano", "3 ESPRESSO"), CAFFE_LATTE("Caffè Latte", "2 ESPRESSO", "STEAMED_MILK"),
	CAFFE_MOCHA("Caffè Mocha", "ESPRESSO", "COCOA", "STEAMED_MILK", "WHIPPED_CREAM"),
	CAPPUCCINO("Cappuccino", "2 ESPRESSO", "STEAMED_MILK", "FOAMED_MILK"),
	COFFEE("Coffee", "3 COFFEE", "SUGAR", "CREAM"), DECAF_COFFEE("Decaf Coffee", "3 DECAF_COFFEE", "SUGAR", "CREAM");

	private final String name;
	private final Map<Ingredient, Integer> recipeIngredients;
	private final BigDecimal cost;

	Drink(String name, String... recipe) {
		Map<Ingredient, Integer> map = new HashMap<Ingredient, Integer>();
		BigDecimal cost = BigDecimal.ZERO;
		for (String spec : recipe) {
			String[] amountOfStuff = spec.split(" ", 2);
			int quantity = (amountOfStuff.length > 1) ? Integer.parseInt(amountOfStuff[0]) : 1;
			String stuff = amountOfStuff[amountOfStuff.length - 1];
			Ingredient ingredient = Enum.valueOf(Ingredient.class, stuff);

			map.put(ingredient, quantity);
			cost = cost.add(ingredient.getCost().multiply(new BigDecimal(quantity)));
		}
		this.name = name;
		this.recipeIngredients = Collections.unmodifiableMap(map);
		this.cost = cost;
	}

	public Map<Ingredient, Integer> getRecipe() {
		return this.recipeIngredients;
	}

	public BigDecimal getPrice() {
		return this.cost;
	}

	public String toString() {
		return this.name;
	}
}
