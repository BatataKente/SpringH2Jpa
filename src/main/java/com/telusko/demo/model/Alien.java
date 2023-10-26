package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Aliens")
public class Alien extends Model {
	@Id
	private int id;
	private String name;
	private String tech;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}

	public String getTech() {
		return tech;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
