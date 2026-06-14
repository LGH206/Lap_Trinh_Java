package com.fe.horseracing.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED) 

// Kế thừa trong JPA - USER đặt là lớp cha --- Admin/ Jockey/.. là lớp con
// tạo users - admins - jockys --- các bảng con lk với user

public abstract class User {
	@Id // tự động tăng ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	private String phoneNumber;
	
	@OneToMany(mappedBy = "bettor")
	private List<Betting> bettings;

	public User() {
	}

	//getter - setter
	public Long getUserId() {
		return userId;
	}

	public List<Betting> getBettings() {
		return bettings;
	}

	public void setBettings(List<Betting> bettings) {
		this.bettings = bettings;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
