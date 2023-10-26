package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
	
//	@Query("from Aliens where tech=?1")
//	List<Alien> findAllByTech(String tech);
//
//	@Query("from Aliens where id>?1")
//	List<Alien> findAllByIdGreaterThan(int id);
//	
//	@Query("from Aliens where tech=?1 order by name")
//	List<Alien> findAllByTechSorted(String tech);
}