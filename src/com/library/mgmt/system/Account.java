package com.library.mgmt.system;

public abstract class Account {

	private int id;
	private String password;
	private AccountStatus status;
	private Person person;

	public abstract boolean resetPassword();

	public int getId() {
		return id;
	}


	public String getPassword() {
		return password;
	}


	public AccountStatus getStatus() {
		return status;
	}


	public Person getPerson() {
		return person;
	}

	

}
