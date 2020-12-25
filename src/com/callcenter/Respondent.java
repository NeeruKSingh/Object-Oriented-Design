package com.callcenter;

public class Respondent extends Employee {

	public Respondent(String name, boolean isFree, CallManager callManager) {
		super(name, isFree, callManager);
		this.rank = 1;
	}

	

}
