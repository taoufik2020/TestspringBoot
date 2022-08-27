package com.test.springboot.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="personne")
public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(length=30, nullable=true)
	private String firstName;
	
	
	@Column(length=30, nullable=true)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String firstName, String lastName, Date birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	

}
