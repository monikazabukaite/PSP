package com.lab3.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	private String name;
	private String surname;
	private String number;
	private String email;
	private String address;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User(String name, String surname, String number, String email, String address, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.number = number;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", number=" + number + ", email=" + email + ", address="
				+ address + ", password=" + password + ", id=" + id + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
