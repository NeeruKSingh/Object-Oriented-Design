package com.cofee.machine;

import java.math.BigDecimal;

public enum Ingredient {
	// An extensible design wouldn't use an enum, but the problem specification
	// allows such hard-coding. These entries must be in alphabetical order.
	COCOA("0.90"), COFFEE("0.75"), CREAM("0.25"), DECAF_COFFEE("0.75"), ESPRESSO("1.10"), FOAMED_MILK("0.35"),
	STEAMED_MILK("0.35"), SUGAR("0.25"), WHIPPED_CREAM("1.00");

	private final String name;
	private final BigDecimal cost;

	Ingredient(String cost) {
		this.name = this.name().replace("_", " ").toLowerCase();
		this.cost = new BigDecimal(cost);
	}

	// Using fixed-point representation to prevent rounding problems
	public BigDecimal getCost() {
		return this.cost;
	}

	public String toString() {
		return this.name;
	}
}
