package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
}
