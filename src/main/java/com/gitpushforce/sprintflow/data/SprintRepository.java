package com.gitpushforce.sprintflow.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>{
	

}
