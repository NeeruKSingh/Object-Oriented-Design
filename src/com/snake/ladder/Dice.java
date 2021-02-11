package com.snake.ladder;

import java.util.Random;

public class Dice {
	public static int roll() {
		return new Random().nextInt(6) + 1; 
	}
}
