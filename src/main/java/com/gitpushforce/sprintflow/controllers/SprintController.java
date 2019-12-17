package com.gitpushforce.sprintflow.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitpushforce.sprintflow.beans.Sprint;
import com.gitpushforce.sprintflow.services.SprintService;


@RestController // Tells Spring that this class is a controller
@RequestMapping(value = "api/sprints")
public class SprintController implements InitializingBean {
	
	private static final Logger log = Logger.getLogger(SprintController.class);
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Autowired
	private SprintService sprintservice;
	
	
	
	@GetMapping
	public ResponseEntity<List<Sprint>> findAll() {
		return new ResponseEntity<List<Sprint>>(sprintservice.findAll(), HttpStatus.OK);
	}
	
	
	
}
