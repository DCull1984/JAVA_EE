package com.BAE.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLASSROOM")
public class ClassroomLayout 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	
	public ClassroomLayout()
	{
		
	}
	
	
}
