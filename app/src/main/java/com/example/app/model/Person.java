package com.example.app.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	private String email;
	private String gender;
	private String name;
	private String phone;
}


