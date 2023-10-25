package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

public interface AlienRepository extends CrudRepository<Alien, Integer> {
	List<Alien> findAll();
}
