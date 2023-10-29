package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
}