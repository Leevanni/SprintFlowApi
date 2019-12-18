package com.gitpushforce.sprintflow.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>{
	
	/*
	 *  If we need crud operations other than the ones that the JpaRespository
	 *  extends then we can create out own
	 */
	
	
	/**
	 * This method returns the top three most recent active sprints for the dashboard page.
	 * @return
	 */
	
	//public List<Sprint> findTop3ActiveSprints();
	
	/**
	 * This method returns the top 4 most recent completed sprints for the dashboard page.
	 * @return
	 */
	//public List<Sprint> findTop4CompletedSprints();
	
	
	@Query("select s from Sprint s inner join s.userstories where s.id = ?1")
	public Sprint findByIdJoinUserstories(int id);
	
}
