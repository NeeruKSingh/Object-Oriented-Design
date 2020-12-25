package com.callcenter;

public class Director extends Employee {

	public Director(String name, boolean isFree, CallManager callManager) {
		super(name, isFree, callManager);
		this.rank = 3;
	}
	
	

}
