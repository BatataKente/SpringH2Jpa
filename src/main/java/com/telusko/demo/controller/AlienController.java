package com.telusko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
