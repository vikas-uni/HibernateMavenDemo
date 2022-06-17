package com.infogain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/*@Embeddable annotation is used to specify the Address class will be used as a component. The Address class cannot have a primary key of its own, it uses the enclosing class primary key.*/
@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	public Address() {
	}

	public Address(String street, String city, String state) {
		this.street = street;
		this.city = city;
		this.state = state;
		
	}
	
	@Column(name = "ADDRESS_STREET", nullable = false, length=250)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "ADDRESS_CITY", nullable = false, length=50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ADDRESS_STATE", nullable = false, length=50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	}
