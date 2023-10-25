package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Aliens")
public class Alien {
	@Id
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{\"id\": " + id + ", \"name\"= \"" + name + "\"}";
	}
}
