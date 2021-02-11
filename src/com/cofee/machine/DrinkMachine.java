package com.cofee.machine;

import java.util.Map;

public class DrinkMachine {
	Inventory<Ingredient> ingredientInventory = new Inventory<Ingredient>();
	
	
	    public Drink[] menu() {
	        return Drink.values();
	    }

	    public boolean canMake(Drink drink) {
	        for (Map.Entry<Ingredient, Integer> quantStuff : drink.getRecipe().entrySet()) {
	            if (ingredientInventory.getStock(quantStuff.getKey()) < quantStuff.getValue()) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public void make(Drink drink) throws OutOfStockException {
	        if (!this.canMake(drink)) {
	            throw new OutOfStockException(drink);
	        }
	        for (Map.Entry<Ingredient, Integer> quantStuff : drink.getRecipe().entrySet()) {
	            int quant = quantStuff.getValue();
	            Ingredient stuff = quantStuff.getKey();
	            ingredientInventory.updateStock(stuff, ingredientInventory.getStock(stuff) - quant);
	        }
	    }

	    public String toString() {
	        StringBuilder out = new StringBuilder("Inventory:\n");
	        for (Ingredient ingredient : Ingredient.values()) {
	            out.append(ingredient).append(": ")
	               .append(ingredientInventory.getStock(ingredient)).append('\n');
	        }
	        out.append("\nMenu:\n");
	        int i = 0;
	        for (Drink drink : Drink.values()) {
	            out.append(++i).append(": ").append(drink);
	            if (this.canMake(drink)) {
	                out.append(", $").append(drink.getPrice());
	            } else {
	                out.append(" (out of stock)");
	            }
	            out.append('\n');
	        }
	        return out.toString();
	    }

	    
	   


}
