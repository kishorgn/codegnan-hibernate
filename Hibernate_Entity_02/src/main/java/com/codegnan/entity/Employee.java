package com.codegnan.entity;

import java.util.List;

public class Employee {
	int eId;
	String name;
	String email;
	List<Address> addresses ;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eId, String name, String email) {
		super();
		this.eId = eId;
		this.name = name;
		this.email = email;
	}
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", email=" + email + "]";
	}
}
