package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class empcontroller {
	
	@GetMapping("/temp")
	public String Details() {
		
		return "inquiry details are stored in db";
	}

}
