package com.callcenter;

public class Employee {
	protected int rank;
	protected String name;
	protected boolean isFree;
	protected CallManager callManager;

	public Employee(String name, boolean isFree, CallManager callManager) {
		this.name = name;
		this.isFree = isFree;
		this.callManager = callManager;
	}

	public void recieveCall(Call call) {
		System.out.println("Employee " + name + " is busy on call with customer " + call.getCustomer().getName());
		this.isFree = false;
	}

	public void endCall(Call call) {
		System.out.println("Employee " + name + " ended call with customer " + call.getCustomer().getName());
		this.isFree = true;
		
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
