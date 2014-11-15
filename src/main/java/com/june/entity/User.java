package com.june.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "fs_user")
public class User extends IdEntity {

	private String username;
	private String name;
	private String password;
	private Boolean remember;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public User(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
