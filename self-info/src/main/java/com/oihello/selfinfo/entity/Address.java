package com.oihello.selfinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	
	private String streetAddress;
	
	private String zipcode;
	
	private String state;
	
	private String country;
	
	@ManyToOne
	private Person person;

	public Address() {
		super();
	}

	public Address(String streetAddress, String zipcode, String state, String country, long personId) {
		super();
		this.streetAddress = streetAddress;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
		this.setPerson(new Person(personId));
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetAddress=" + streetAddress + ", zipcode=" + zipcode
				+ ", state=" + state + ", country=" + country + ", person=" + person + "]";
	}
}
