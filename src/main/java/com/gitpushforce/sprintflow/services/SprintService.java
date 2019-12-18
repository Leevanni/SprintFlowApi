package com.gitpushforce.sprintflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitpushforce.sprintflow.beans.Sprint;
import com.gitpushforce.sprintflow.beans.Userstory;
import com.gitpushforce.sprintflow.data.SprintRepository;
import com.gitpushforce.sprintflow.data.UserstoryRepository;

@Service
public class SprintService {

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
			return sprintRepository.save(sprint);
		}
		else {
			Sprint result = sprintRepository.save(sprint);
			for(Userstory userstory: sprint.getUserStories()) {
				userstoryRepository.save(userstory);
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
	
	
	
	
	
	
}
