package com.Web.model;

// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "")
public class Users implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String pwd;
	private Date setdate;

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String id, String name, String pwd, Date setdate) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.setdate = setdate;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pwd", nullable = false, length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "setdata", unique = true, nullable = false)
	public Date getSetdate() {
		return setdate;
	}

	public void setSetdate(Date date) {
		this.setdate = date;
	}
}