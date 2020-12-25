package com.callcenter;

public class Manager extends Employee {

	public Manager(String name, boolean isFree, CallManager callManager) {
		super(name, isFree, callManager);
		this.rank = 2;
	}

	

}
