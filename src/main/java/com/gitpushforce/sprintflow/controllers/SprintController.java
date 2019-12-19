package com.gitpushforce.sprintflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitpushforce.sprintflow.beans.Sprint;
import com.gitpushforce.sprintflow.data.SprintRepository;
import com.gitpushforce.sprintflow.services.SprintService;


@RestController // Tells Spring that this class is a controller
@RequestMapping(value = "api/sprints")
public class SprintController implements InitializingBean {
	
	private static final Logger log = Logger.getLogger(SprintController.class);
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private SprintService sprintService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/sprint", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Sprint> create(@Valid @RequestBody Sprint sprint) {
		// calling service.save() will propogate that TX forward
		return new ResponseEntity<Sprint>(sprintService.save(sprint), HttpStatus.CREATED);
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Sprint>> findAll() {
		return new ResponseEntity<List<Sprint>>(sprintService.findAll(), HttpStatus.OK);
	}
	

	/*
	@GetMapping(value = "/sprints/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sprint> findByIdJoinUserstories(@PathVariable int id) {
		return new ResponseEntity<Sprint>(sprintservice.findByIdJoinUserstores(id), HttpStatus.OK);
	}
	*/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/sprints/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sprint> findByIdJoinUserstories(@PathVariable int id) {
		return new ResponseEntity<Sprint> (sprintService.findByIdJoinUserstores(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/sprints/{id}")
	public void deleteSprint(@PathVariable int id) {
		sprintService.deleteSprint(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/sprints/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sprint> update(@Valid @RequestBody Sprint sprint, @PathVariable int id){
		if(!sprintRepository.existsById(id) || sprint.getId() == 0) {
			return new ResponseEntity<Sprint> (HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Sprint> (sprintService.save(sprint), HttpStatus.NO_CONTENT);
	}	
}
