package com.gitpushforce.sprintflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitpushforce.sprintflow.beans.Sprint;
import com.gitpushforce.sprintflow.data.SprintRepository;
import com.gitpushforce.sprintflow.data.UserstoryRepository;

@Service
public class SprintService {

	@Autowired
	private SprintRepository sprintRepo;
	
	@Autowired
	private UserstoryRepository userstoryRepo;
	
	
	public List<Sprint> findAll(){
		return sprintRepo.findAll();
	}
}
