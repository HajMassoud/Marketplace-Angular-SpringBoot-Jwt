package com.smartnet.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Table (name = "user") :user is a reserved keyword in postgresql. Change your table name to something else
@Entity 
@Table (name = "userss",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"
				+ ""),
		@UniqueConstraint(columnNames = "email") 
	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id ;
	@Column(name="code")
	private String code;
	@NotBlank
	@Size(max = 40)
	@Column(name="username")
	private String username;
	@Size(max = 60)
	@Email
	@Column(name="email")
	private String email ;
	@Column(name="passwordss")
	private String password ;
	@Column(name="role")
	private String role ;
	@Column(name="isActive")
	private boolean isActive;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", isActive=" + isActive + "]";
	}
	
	
	public User(long id,String code,String username, String email, String password, String role,boolean isActive) {
		super();
		this.id = id;
		this.code=code;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isActive=isActive;
		
	}
	public User() {
		super();
	}
	

}
