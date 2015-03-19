package com.codin.vo;

public class Member {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String phone;
	public Member(){}
	public Member(String id, String password, String name, String gender, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
