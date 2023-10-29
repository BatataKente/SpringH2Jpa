package com.telusko.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.AlienRepository;
import com.telusko.demo.model.Alien;

@RestController
@RequestMapping("/aliens")
public class AlienController {
	
	@Autowired
	AlienRepository alienRepository;
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Alien> delete(@PathVariable final int id) {
		final Alien alien = alienRepository.findById(id).orElse(null);
		if(alien == null) return new ResponseEntity<Alien>(HttpStatus.NOT_FOUND);
		alienRepository.delete(alien);
		return new ResponseEntity<Alien>(alien, HttpStatus.OK);
	}
	
	@PutMapping
	private ResponseEntity<Alien> put(@RequestBody final Alien alien) {
		alienRepository.save(alien);
		return new ResponseEntity<Alien>(alien, HttpStatus.OK);
	}
	
	@PostMapping
	private ResponseEntity<Object> post(@RequestBody final Alien alien) {
		final int id = alien.getId();
		if(alienRepository.findById(id).orElse(null) != null) {
			return new ResponseEntity<Object>(
					"alien by id " + id + " already exists.", HttpStatus.FORBIDDEN
			);
		}
		alienRepository.save(alien);
		return new ResponseEntity<Object>(alien, HttpStatus.OK);
	}
	
	@GetMapping
	private Iterable<Alien> getAll() {
		return alienRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	private ResponseEntity<Optional<Alien>> getById(@PathVariable final int id) {
		final Optional<Alien> alien = alienRepository.findById(id);
		return new ResponseEntity<Optional<Alien>>(alien, HttpStatus.OK);
	}
}
