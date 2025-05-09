package com.example.app.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Session {
	@Id
	private String id;
	private Date date;
	private String description;
	private String name;
	private Time time;
	
	@ManyToOne
	@JoinColumn(name ="workshop_id")
	private Workshop workshop;
	
	@ManyToMany(mappedBy="sessions")
	private List<PostGraduate> postGraduates;
	
	@ManyToMany(mappedBy="sessions")
	private List<UnderGraduate>underGraduates;
	
	@ManyToMany(mappedBy="sessions")
	private List<Presenter>presenters;

}
