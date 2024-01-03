package com.codegnan.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	int uId;
	String username;
	String email;
	Set<Group> groups = new HashSet<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uId, String username, String email) {
		super();
		this.uId = uId;
		this.username = username;
		this.email = email;
	}
	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", email=" + email + "]";
	}
}
