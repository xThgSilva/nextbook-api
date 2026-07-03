package com.nextbook.requests;

public class UserRequestDTO {
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String phone;
	private int age;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}
}
