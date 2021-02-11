package com.cofee.machine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

	

    private Map<Ingredient, Integer> stock = new HashMap<Ingredient, Integer>();

    public int getStock(Ingredient ingredient) {
        return this.stock.containsKey(ingredient) ?
               this.stock.get(ingredient) : 0;
    }

    public void restock() {
        for (Ingredient ingredient : Ingredient.values()) {
            if (this.getStock(ingredient) < 10) {
                this.stock.put(ingredient, 10);
            }
        }
    }

	public void updateStock(Ingredient stuff, int value) {
		stock.put(stuff, value);
		
	}

	@Override
	public String toString() {
		return "Inventory [stock=" + stock + "]";
	}

	public Integer toString(String name) {
		return stock.get(Ingredient.valueOf(name));
	}
	
	

}
