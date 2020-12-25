package com.callcenter;

public class Call {
	private int rank;
	private Customer customer;

	public int getRank() {
		return rank;
	}

	public Call(int rank, Customer customer) {
		this.rank = rank;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
