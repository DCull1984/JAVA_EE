package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Register 
{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String firstName;
	private String secondName;
	
	public Register() 
	{

	}

	public Register(String pFirstName, String pSecondName) 
	{
		this.firstName = pFirstName;
		this.secondName = pSecondName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String pFirstName) 
	{
		this.firstName = pFirstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String pSecondName)
	{
		this.secondName = pSecondName;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long pId) 
	{
		this.id = pId;
	}

}
