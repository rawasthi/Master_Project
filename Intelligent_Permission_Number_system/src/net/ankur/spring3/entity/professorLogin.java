package net.ankur.spring3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="professor_login_data")
public class professorLogin {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="username", nullable=false)
	private String name;
	
	@Column(name="password", nullable=false)
	private String password;

	public professorLogin(String name) {
		super();
		this.name = name;
	}

	public professorLogin() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

}
