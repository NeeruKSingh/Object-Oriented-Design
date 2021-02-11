package com.library.mgmt.system;

public class Address {
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public String getZipcode() {
		return zipcode;
	}

}
