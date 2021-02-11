package com.jukebox;

public class User {
	private String name;
	private long id;

	public User(String name, long iD) {
		this.name = name;
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public User getUser() {
		return this;
	}

	public static User addUser(String name, long iD) {
		return new User(name, iD);
	}

}
