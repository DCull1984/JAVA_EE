package com.BAE.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLASSROOM")

public class ClassroomLayout 
{
	@OneToMany(mappedBy="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	
	public ClassroomLayout()
	{
		
	}
	
	
}
