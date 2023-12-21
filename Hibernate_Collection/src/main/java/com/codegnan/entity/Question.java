package com.codegnan.entity;

import java.util.Set;

public class Question {
	int id;
	String qname;
	Set<String> answer;
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
	public Set<String> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<String> answer) {
		this.answer = answer;
	}
	
}
