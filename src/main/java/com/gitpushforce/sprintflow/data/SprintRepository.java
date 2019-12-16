package com.gitpushforce.sprintflow.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>{
	
/*
 *  If we need crud operations other than the ones that the JpaRespository
 *  extends then we can create out own
 */
	
	

}
