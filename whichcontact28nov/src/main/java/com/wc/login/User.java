package com.wc.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	// public User(int id , String name, String email, String password ,boolean
	// is_admin) {
	// this.setId(id);
	// this.setName(name);
	// this.setEmail(email);
	// this.setPassword(password);
	// this.setIs_admin(is_admin);
	//
	// }

	@Id
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_email_id")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "is_admin")
	private boolean is_admin;

	public User() {

	}

	public User(String email, String password, String name, boolean is_admin) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setIs_admin(is_admin);

	}

}