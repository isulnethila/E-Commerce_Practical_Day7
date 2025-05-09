package com.example.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class PostGraduate extends Person {
	@Id
	private String id;
	private String institute;
	private String researchInterest;
	private String secondDegree;
	
	@ManyToMany
	@JoinTable(name="post_graduate_sessions",
		joinColumns=@JoinColumn(name="post_graduate_id"),
		inverseJoinColumns=@JoinColumn(name="session_id"))
	private List<Session>sessions;

}
