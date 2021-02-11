package com.vending.machine;

public class SoldOutException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7129499718370632011L;
	private String message;
	   
	    public SoldOutException(String string) {
	        this.message = string;
	    }
	   
	    @Override
	    public String getMessage(){
	        return message;
	    }
}
