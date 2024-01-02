package com.codegnan.entity;

public class Address {
	int aId;
	String street;
	String city;
	Employee employee ;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int aId, String street, String city) {
		super();
		this.aId = aId;
		this.street = street;
		this.city = city;
	}
	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Address [aId=" + aId + ", street=" + street + ", city=" + city + "]";
	}
	
}
