package com.gitpushforce.sprintflow.services;

import java.util.List;
import java.util.Set;

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
	 * Finds the sprint with the id that is sent through the parameter
	 * @param id
	 * @return
	 */
	public Sprint findByIdJoinUserstores(int id) {
		return sprintRepository.findByIdJoinUserstories(id);
	}
	
	/**
	 * Deletes a sprint in the database
	 * @param id
	 */
	public void deleteSprint(int id) {
		sprintRepository.deleteById(id);
		
	}
	
	/**
	 * Finds the top 3 active sprints for the dashboard
	 * @return
	 */
	public Set<Sprint> findTop3ActiveSprints(){
		String status = "Completed";
		return sprintRepository.findTop3ByStatusNotOrderByTimeStampDesc(status);
	}
	
	/**
	 * Finds the top 4 completed sprints for the dashboard.
	 * @return
	 */
	public Set<Sprint> findTop4CompletedSprints(){
		String status = "Completed";
		return sprintRepository.findTop4ByStatusOrderByTimeStampDesc(status);
	}
}
