package com.vending.machine;

public class NotSufficientChangeException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1914087856207605692L;
	private String message;
	   
	    public NotSufficientChangeException(String string) {
	        this.message = string;
	    }
	   
	    @Override
	    public String getMessage(){
	        return message;
	    }
}
