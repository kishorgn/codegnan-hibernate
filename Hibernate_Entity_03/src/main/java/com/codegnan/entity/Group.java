package com.codegnan.entity;

import java.util.HashSet;
import java.util.Set;

public class Group {
	int gId;
	String name;
	Set<User> users = new HashSet<>();
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int gId, String name) {
		super();
		this.gId = gId;
		this.name = name;
	}
	public Group(String name) {
		super();
		this.name = name;
	}
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Group [gId=" + gId + ", name=" + name + "]";
	}
}
