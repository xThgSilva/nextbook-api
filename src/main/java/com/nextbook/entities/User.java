package com.nextbook.entities;

import com.nextbook.requests.UserRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String password;
	
	@Column(length = 11, nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	public User() { }
	
	public User(UserRequestDTO dto) {
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.phone = dto.getPhone();
		this.age = dto.getAge();
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
