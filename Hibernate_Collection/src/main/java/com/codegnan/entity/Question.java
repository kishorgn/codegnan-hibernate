package com.codegnan.entity;

import java.util.Map;
import java.util.Set;

public class Question {
	int id;
	String qname;
	String username;
	Map<String, String> answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<String, String> getAnswer() {
		return answer;
	}
	public void setAnswer(Map<String, String> answer) {
		this.answer = answer;
	}
	
}
