package com.telusko.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telusko.demo.dao.AlienRepository;
import com.telusko.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepository alienRepository;
	
	@RequestMapping("/*")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	private String addAlien(Alien alien) {
		alienRepository.save(alien);
		return "home.jsp";
	}
	
//	@RequestMapping("/getAlien")
//	private ModelAndView getAlien(final int id) {
//		ModelAndView modelAndView = new ModelAndView("showAlien.jsp");
//		Alien alien = alienRepository.findById(id).orElse(new Alien());
//		
//		System.out.println(alienRepository.findAllByTech("Java"));
//		System.out.println(alienRepository.findAllByIdGreaterThan(600));
//		System.out.println(alienRepository.findAllByTechSorted("Java"));
//		
//		modelAndView.addObject(alien);
//		return modelAndView;
//	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	private Iterable<Alien> getAliens() {
		return alienRepository.findAll();
	}
	
	@RequestMapping("/aliens/{id}")
	@ResponseBody
	private Optional<Alien> getAlien(@PathVariable final int id) {
		return alienRepository.findById(id);
	}
}
