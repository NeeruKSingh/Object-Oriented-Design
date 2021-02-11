package com.cofee.machine;

public class OutOfStockException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -8834294164219444510L;

	OutOfStockException(Drink drink) {
         super(drink.toString());
     }
}
