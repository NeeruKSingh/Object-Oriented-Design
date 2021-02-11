package com.snake.ladder;

public class GameAlreadyEndException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2099513912843961306L;

	GameAlreadyEndException(String msg){
		super(msg);
	}
}
