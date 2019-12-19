package com.gitpushforce.sprintflow.data;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gitpushforce.sprintflow.beans.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>{
	/**
	 * This method returns the top 3 most recent active sprints for the dashboard page.
	 * @return
	 */
	public Set<Sprint> findTop3ByStatusNotOrderByTimeStampDesc(String status);
	
	/**
	 * This returns the top 4 recently completed sprints for the dashboard page.
	 * @return
	 */
	public Set<Sprint> findTop4ByStatusOrderByTimeStampDesc(String status);
	
	/**
	 * This returns the sprint with the id of the parameter and includes the userstories as well as comment.
	 * @param id
	 * @return
	 */
	@Query("select s from Sprint s inner join s.userStories where s.id = ?1")
	public Sprint findByIdJoinUserstories(int id);
	
	//List<Userstory> findBySprintStartDate(Date date)

	
	
}
