package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class UnderGraduate extends Person{
	
	@Id
	private String id;
	private String degree;
	private String university;
	

	@ManyToMany
	@JoinTable(name="under_graduate_sessions",
			joinColumns = @JoinColumn(name="under_graduate_id"),
			inverseJoinColumns = @JoinColumn(name="session_id"))
	private List<Session>sessions;

}
