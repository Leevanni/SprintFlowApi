package com.gitpushforce.sprintflow.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells Spring that this class is a controller
public class SprintController {
	
	@RequestMapping("/") // Any request (GET, POST, PUT, etc) to the root url will be handled by this method
	public String index() {
		return "Congratulations from SprintController.java";
	}
}
