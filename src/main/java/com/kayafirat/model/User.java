package com.kayafirat.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "verification")
	private boolean verification;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "token")
	private String token;
	
	public User() {}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.verification = false;
		this.role = "ROLE_USER";
		this.token = UUID.randomUUID().toString();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerification() {
		return verification;
	}
	public void setVerification(boolean verification) {
		this.verification = verification;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", verification="
				+ verification + ", role=" + role + "]";
	}
	
}
