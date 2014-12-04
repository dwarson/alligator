package com.june.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.ImmutableList;

@Entity
@Table(name = "fs_user")
public class User extends IdEntity {

	private String username;
	private String name;
	private String password;
	private String plainPassword;
	private String salt;
	private String roles;
	private Boolean remember;
	private Date registerDate;

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

	// Do not persistent
	@Transient
	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Transient
	public List<String> getRoleList() {
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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
