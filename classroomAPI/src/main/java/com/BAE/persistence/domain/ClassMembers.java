package com.BAE.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClassMembers {

	@ManyToOne
	@JoinColumn(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;	
	private String firstName;	
	private String secondName;
	
	public ClassMembers() {

	}

	public ClassMembers(Long id, String firstName, String secondName) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
