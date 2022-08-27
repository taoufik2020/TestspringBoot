package com.test.springboot.Dto;

import java.util.Date;




public class PersonneDto {

	
    private String firstName;
	
	

	private String lastName;
	
	
	private Date birthday;


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


	public PersonneDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
