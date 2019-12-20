package com.gitpushforce.sprintflow.services;


import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitpushforce.sprintflow.beans.Sprint;
import com.gitpushforce.sprintflow.beans.Userstory;
import com.gitpushforce.sprintflow.controllers.SprintController;
import com.gitpushforce.sprintflow.data.SprintRepository;
import com.gitpushforce.sprintflow.data.UserstoryRepository;

@Service
public class SprintService {
	private static final Logger log = Logger.getLogger(SprintService.class);

	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private UserstoryRepository userstoryRepository;
	
	/**
	 * Finds all sprints
	 * @return
	 */
	public List<Sprint> findAll(){
		return sprintRepository.findAll();
	}
	
	/**
	 * Saves a sprint in the database
	 * @param sprint
	 * @return
	 */
	public Sprint save(Sprint sprint) {
		
		if(sprint.getUserStories() == null || sprint.getUserStories().isEmpty()) {
			sprint.setStatus("planning");
			log.info("Save Sprint: User story: null");
			// Set time date created and timestamp
			sprint.setTimeStamp(currentTimeAndDate());
			
			if(sprint.getDateCreated() == null) {
			sprint.setDateCreated(currentTimeAndDate());
			}
			log.info("Timestamp:  " + sprint.getTimeStamp());
			return sprintRepository.save(sprint);
		
		}
		else {
			log.info("Save Sprint");
			
			// Set time date created and timestamp
			sprint.setTimeStamp(currentTimeAndDate());
			
			if(sprint.getDateCreated() == null) {
			sprint.setDateCreated(currentTimeAndDate());
			}
			log.info("Timestamp:  " + sprint.getTimeStamp());
			
			Sprint result = sprintRepository.save(sprint);
			log.info("Save Sprint:  " + result.toString());
			
			// Save userstories from sprint
			for(Userstory userstory: sprint.getUserStories()) {
				userstoryRepository.save(userstory);
				log.info("Save Sprint: User story: " + userstory.toString());
			}
	
			return result;
		}	
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Sprint findByIdJoinUserstores(int id) {
		return sprintRepository.findByIdJoinUserstories(id);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 *
	public Sprint findById(int id) {
		return sprintRepository.findById(id).get();
	}
	*/
	
	
	public void deleteSprint(int id) {
		sprintRepository.deleteById(id);
		
	}
	
	public Date currentTimeAndDate() {
		return new Date();  
	}
	
	
}
